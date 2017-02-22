package com.taobao.api.internal.mapping;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.qimen.api.QimenResponse;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.internal.util.StringUtils;

/**
 * 转换工具类。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class Converters {

	/**
	 * 是否对JSON返回的数据类型进行校验，默认不校验。给内部测试JSON返回时用的开关。
	 * 规则：返回的"基本"类型只有String,Long,Boolean,Date,采取严格校验方式，如果类型不匹配，报错
	 */
	public static boolean isCheckJsonType = false;

	private static final Map<String, Set<String>> baseProps = new HashMap<String, Set<String>>();
	private static final Map<String, Field> fieldCache = new ConcurrentHashMap<String, Field>();

	static {
		baseProps.put(TaobaoResponse.class.getName(), StringUtils.getClassProperties(TaobaoResponse.class, false));
		baseProps.put(QimenResponse.class.getName(), StringUtils.getClassProperties(QimenResponse.class, false));
	}

	private Converters() {
	}

	/**
	 * 使用指定 的读取器去转换字符串为对象。
	 * 
	 * @param <T> 领域泛型
	 * @param clazz 领域类型
	 * @param reader 读取器
	 * @return 领域对象
	 * @throws ApiException
	 */
	public static <T> T convert(Class<T> clazz, Reader reader) throws ApiException {
		T rsp = null;

		try {
			rsp = clazz.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor pd : pds) {
				Method method = pd.getWriteMethod();
				if (method == null) { // ignore read-only fields
					continue;
				}

				String itemName = pd.getName();
				String listName = null;

				Field field = null;
				Set<String> stopProps = baseProps.get(clazz.getSuperclass().getName());
				if (stopProps != null && stopProps.contains(itemName)) {
					field = getField(clazz.getSuperclass(), pd);
				} else {
					field = getField(clazz, pd);
				}
				if (field == null) {
					continue;
				}

				ApiField jsonField = field.getAnnotation(ApiField.class);
				if (jsonField != null) {
					itemName = jsonField.value();
				}
				ApiListField jsonListField = field.getAnnotation(ApiListField.class);
				if (jsonListField != null) {
					listName = jsonListField.value();
				}

				if (!reader.hasReturnField(itemName)) {
					if (listName == null || !reader.hasReturnField(listName)) {
						continue; // ignore non-return field
					}
				}

				Class<?> typeClass = field.getType();
				// 目前
				if (String.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof String) {
						method.invoke(rsp, value.toString());
					} else {
						if (isCheckJsonType && value != null) {
							throw new ApiException(itemName + " is not a String");
						}
						if (value != null) {
							method.invoke(rsp, value.toString());
						} else {
							method.invoke(rsp, "");
						}
					}
				} else if (Long.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof Long) {
						method.invoke(rsp, (Long) value);
					} else {
						if (isCheckJsonType && value != null) {
							throw new ApiException(itemName + " is not a Number(Long)");
						}
						if (StringUtils.isNumeric(value)) {
							method.invoke(rsp, Long.valueOf(value.toString()));
						}
					}
				} else if (Boolean.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof Boolean) {
						method.invoke(rsp, (Boolean) value);
					} else {
						if (isCheckJsonType && value != null) {
							throw new ApiException(itemName + " is not a Boolean");
						}
						if (value != null) {
							method.invoke(rsp, Boolean.valueOf(value.toString()));
						}
					}
				} else if (Date.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof String) {
						method.invoke(rsp, StringUtils.parseDateTime(value.toString()));
					}
				} else if (List.class.isAssignableFrom(typeClass)) {
					Type fieldType = field.getGenericType();
					if (fieldType instanceof ParameterizedType) {
						ParameterizedType paramType = (ParameterizedType) fieldType;
						Type[] genericTypes = paramType.getActualTypeArguments();
						if (genericTypes != null && genericTypes.length > 0) {
							if (genericTypes[0] instanceof Class<?>) {
								Class<?> subType = (Class<?>) genericTypes[0];
								List<?> listObjs = reader.getListObjects(listName, itemName, subType);
								if (listObjs != null) {
									method.invoke(rsp, listObjs);
								}
							}
						}
					}
				} else if (Integer.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof Integer) {
						method.invoke(rsp, (Integer) value);
					} else {
						if (isCheckJsonType && value != null) {
							throw new ApiException(itemName + " is not a Number(Integer)");
						}
						if (StringUtils.isNumeric(value)) {
							method.invoke(rsp, Integer.valueOf(value.toString()));
						}
					}
				} else if (Double.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof Double) {
						method.invoke(rsp, (Double) value);
					} else {
						if (isCheckJsonType && value != null) {
							throw new ApiException(itemName + " is not a Double");
						}
					}
				} else if (Number.class.isAssignableFrom(typeClass)) {
					Object value = reader.getPrimitiveObject(itemName);
					if (value instanceof Number) {
						method.invoke(rsp, (Number) value);
					} else {
						if (isCheckJsonType && value != null) {
							throw new ApiException(itemName + " is not a Number");
						}
					}
				} else {
					Object obj = reader.getObject(itemName, typeClass);
					if (obj != null) {
						method.invoke(rsp, obj);
					}
				}
			}
		} catch (Exception e) {
			throw new ApiException(e);
		}

		return rsp;
	}

	private static Field getField(Class<?> clazz, PropertyDescriptor pd) throws Exception {
		String key = new StringBuilder(clazz.getName()).append("_").append(pd.getName()).toString();
		Field field = fieldCache.get(key);
		if (field == null) {// 这个方法不加锁，初始化并发也没关系，无非多put几次
			try {
				field = clazz.getDeclaredField(pd.getName());
				fieldCache.put(key, field);
			} catch (NoSuchFieldException e) {
				return null;
			}
		}
		return field;
	}
}
