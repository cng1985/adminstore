package com.taobao.api.internal.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 对象转XML类。
 * 
 * @author fengsheng
 * @since Jan 28, 2016
 */
public class XmlWriter {

	private StringBuffer buf = new StringBuffer();
	private Stack<Object> calls = new Stack<Object>();
	private boolean omitClassName;
	private String rootTagName;
	private Class<?> stopClass;
	private Set<String> stopProps;

	public XmlWriter(boolean omitClassName, String rootTagName, Class<?> stopClass) {
		this.omitClassName = omitClassName;
		this.rootTagName = rootTagName;
		this.stopClass = stopClass;
		this.stopProps = StringUtils.getClassProperties(stopClass, true);
	}

	public XmlWriter() {
		this(true, null, null);
	}

	public String write(Object object) {
		buf.setLength(0);
		String tagName = rootTagName;
		if (tagName == null) {
			tagName = StringUtils.toCamelStyle(object.getClass().getSimpleName());
		}
		startTag(tagName);
		value(object);
		endTag(tagName);
		return buf.toString();
	}

	private void value(Object object) {
		if (object == null || cyclic(object)) {
			add(null);
		} else {
			calls.push(object);
			if (object instanceof Class<?>) string(object);
			else if (object instanceof Boolean) bool(((Boolean) object).booleanValue());
			else if (object instanceof Number) add(object);
			else if (object instanceof String) string(object);
			else if (object instanceof Character) string(object);
			else if (object instanceof Map<?, ?>) map((Map<?, ?>) object);
			else if (object.getClass().isArray()) array(object);
			else if (object instanceof Collection<?>) array((Collection<?>) object);
			else if (object instanceof Date) date((Date) object);
			else bean(object);
			calls.pop();
		}
	}

	private boolean cyclic(Object object) {
		Iterator<Object> it = calls.iterator();
		while (it.hasNext()) {
			Object called = it.next();
			if (object == called) return true;
		}
		return false;
	}

	private void bean(Object object) {
		BeanInfo info;
		try {
			info = Introspector.getBeanInfo(object.getClass());
			boolean isChildren = stopClass != null && stopClass.isAssignableFrom(object.getClass());
			PropertyDescriptor[] props = info.getPropertyDescriptors();
			for (int i = 0; i < props.length; ++i) {
				PropertyDescriptor prop = props[i];
				String name = prop.getName();
				if (isChildren && stopProps.contains(name)) continue;
				Method accessor = prop.getReadMethod();
				if ((!omitClassName || !"class".equals(name)) && accessor != null) {
					if (!accessor.isAccessible()) accessor.setAccessible(true);
					Object value = accessor.invoke(object, (Object[]) null);
					if (value == null) continue;
					add(name, value);
				}
			}
			Field[] ff = object.getClass().getFields();
			for (int i = 0; i < ff.length; ++i) {
				Field field = ff[i];
				Object value = field.get(object);
				if (value == null) continue;
				add(field.getName(), value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void add(String name, Object value) {
		startTag(name);
		value(value);
		endTag(name);
	}

	private void map(Map<?, ?> map) {
		Iterator<?> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) it.next();
			startTag(String.valueOf(e.getKey()));
			value(e.getValue());
			endTag(String.valueOf(e.getKey()));
		}
	}

	private void array(Collection<?> object) {
		String tagName = null;
		for (Object item : object) {
			if (tagName == null) {
				tagName = StringUtils.toCamelStyle(item.getClass().getSimpleName());
			}
			startTag(tagName);
			value(item);
			endTag(tagName);
		}
	}

	private void array(Object object) {
		String tagName = null;
		int length = Array.getLength(object);
		for (int i = 0; i < length; ++i) {
			Object item = Array.get(object, i);
			if (tagName == null) {
				tagName = StringUtils.toCamelStyle(item.getClass().getSimpleName());
			}
			startTag(tagName);
			value(item);
			endTag(tagName);
		}
	}

	private void bool(boolean b) {
		add(b ? "true" : "false");
	}

	private void date(Date date) {
		add(StringUtils.formatDateTime(date));
	}

	private void string(Object obj) {
		add(StringUtils.escapeXml(obj.toString()));
	}

	private void add(Object obj) {
		buf.append(obj);
	}

	private void startTag(String tagName) {
		buf.append("<");
		buf.append(tagName);
		buf.append(">");
	}

	private void endTag(String tagName) {
		buf.append("</");
		buf.append(tagName);
		buf.append(">");
	}

}
