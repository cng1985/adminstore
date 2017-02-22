package com.taobao.api.internal.spi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.internal.util.TaobaoUtils;
import com.taobao.api.internal.util.WebUtils;

/**
 * SPI服务提供方工具类。
 */
public class SpiUtils {

	private static final Log log = LogFactory.getLog(SpiUtils.class);

	private static final String TOP_SIGN_LIST = "top-sign-list";
	private static final String TOP_FIELD_SIGN = "sign";
	private static final String TOP_FIELD_TS = "timestamp";
	private static final String[] HEADER_FIELDS_IP = {"X-Real-IP", "X-Forwarded-For", "Proxy-Client-IP",
		"WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};

	/**
	 * 校验SPI请求签名，适用于所有GET请求，及不包含文件参数的POST请求。
	 * 
	 * @param request 请求对象
	 * @param secret app对应的secret
	 * @return true：校验通过；false：校验不通过
	 */
	public static boolean checkSign4FormRequest(HttpServletRequest request, String secret) throws IOException {
		String charset = WebUtils.getResponseCharset(request.getContentType());
		return checkSign(request, null, null, secret, charset);
	}

	/**
	 * 校验SPI请求签名，适用于请求体是xml/json等可用文本表示的POST请求。
	 * 
	 * @param request 请求对象
	 * @param body 请求体的文本内容
	 * @param secret app对应的secret
	 * @return true：校验通过；false：校验不通过
	 */
	public static boolean checkSign4TextRequest(HttpServletRequest request, String body, String secret) throws IOException {
		String charset = WebUtils.getResponseCharset(request.getContentType());
		return checkSign(request, null, body, secret, charset);
	}

	/**
	 * 校验SPI请求签名，适用于带文件上传的POST请求。
	 * 
	 * @param request 请求对象
	 * @param form 除了文件参数以外的所有普通文本参数的map集合
	 * @param secret app对应的secret
	 * @return true：校验通过；false：校验不通过
	 */
	public static boolean checkSign4FileRequest(HttpServletRequest request, Map<String, String> form, String secret) throws IOException {
		String charset = WebUtils.getResponseCharset(request.getContentType());
		return checkSign(request, form, null, secret, charset);
	}

	private static boolean checkSign(HttpServletRequest request, Map<String, String> form, String body, String secret, String charset) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		// 1. 获取header参数
		Map<String, String> headerMap = getHeaderMap(request, charset);
		params.putAll(headerMap);

		// 2. 获取url参数
		Map<String, String> queryMap = getQueryMap(request, charset);
		params.putAll(queryMap);

		// 3. 获取form参数
		if (form == null && body == null) {
			Map<String, String> formMap = getFormMap(request, queryMap);
			params.putAll(formMap);
		} else if (form != null) {
			params.putAll(form);
		}

		// 4. 生成签名并校验
		String remoteSign = queryMap.get(TOP_FIELD_SIGN);
		String localSign = sign(params, body, secret, charset);
		if (localSign.equals(remoteSign)) {
			return true;
		} else {
			String paramStr = getParamStrFromMap(params);
			log.error("checkTopSign error^_^remoteSign=" + remoteSign + "^_^localSign=" + localSign + "^_^paramStr=" + paramStr + "^_^body=" + body);
			return false;
		}
	}

	/**
	 * 获取header参数为map
	 */
	public static Map<String, String> getHeaderMap(HttpServletRequest request, String charset) throws IOException {
		Map<String, String> headerMap = new HashMap<String, String>();
		String signList = request.getHeader(TOP_SIGN_LIST); // 只获取参与签名的头部字段
		if (!StringUtils.isEmpty(signList)) {
			String[] keys = signList.split(",");
			for (String key : keys) {
				String value = request.getHeader(key);
				if (StringUtils.isEmpty(value)) {
					headerMap.put(key, "");
				} else {
					headerMap.put(key, URLDecoder.decode(value, charset));
				}
			}
		}
		return headerMap;
	}

	/**
	 * 获取url参数为map
	 */
	public static Map<String, String> getQueryMap(HttpServletRequest request, String charset) throws IOException {
		Map<String, String> queryMap = new HashMap<String, String>();
		String queryString = request.getQueryString();
		String[] params = queryString.split("&");
		for (int i = 0; i < params.length; i++) {
			String[] kv = params[i].split("=");
			if (kv.length == 2) {
				String key = URLDecoder.decode(kv[0], charset);
				String value = URLDecoder.decode(kv[1], charset);
				queryMap.put(key, value);
			} else if (kv.length == 1) { // 参数值为空
				String key = URLDecoder.decode(kv[0], charset);
				queryMap.put(key, "");
			}
		}
		return queryMap;
	}

	/**
	 * 获取表单参数为map
	 */
	public static Map<String, String> getFormMap(HttpServletRequest request, Map<String, String> queryMap) throws IOException {
		Map<String, String> formMap = new HashMap<String, String>();
		Set<?> keys = request.getParameterMap().keySet();
		for (Object tmp : keys) {
			String key = String.valueOf(tmp);
			if (!queryMap.containsKey(key)) {
				String value = request.getParameter(key);
				if (StringUtils.isEmpty(value)) {
					formMap.put(key, "");
				} else {
					formMap.put(key, value);
				}
			}
		}
		return formMap;
	}

	/**
	 * 获取body为字符串
	 */
	public static String getStreamAsString(InputStream stream, String charset) throws IOException {
		return WebUtils.getStreamAsString(stream, charset);
	}

	/**
	 * 签名规则：hex(md5(secret+sorted(header_params+url_params+form_params)+body+secret)
	 */
	private static String sign(Map<String, String> params, String body, String secret, String charset) throws IOException {
		StringBuilder sb = new StringBuilder(secret);
		sb.append(getParamStrFromMap(params));
		if (body != null) {
			sb.append(body);
		}
		sb.append(secret);
		byte[] bytes = TaobaoUtils.encryptMD5(sb.toString().getBytes(charset));
		return TaobaoUtils.byte2hex(bytes);
	}

	private static String getParamStrFromMap(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		if (params != null && !params.isEmpty()) {
			String[] keys = params.keySet().toArray(new String[0]);
			Arrays.sort(keys);
			for (int i = 0; i < keys.length; i++) {
				String name = keys[i];
				if (!TOP_FIELD_SIGN.equals(name)) {
					sb.append(name);
					sb.append(params.get(name));
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 检查SPI请求到达服务器端是否已经超过5分钟，如果超过则拒绝请求。
	 * 
	 * @return true代表不超过5分钟，false代表超过5分钟。
	 */
	public static boolean checkTimestamp(HttpServletRequest request) {
		String ts = request.getParameter(TOP_FIELD_TS);
		if (ts != null) {
			long remote = StringUtils.parseDateTime(ts).getTime();
			long local = Calendar.getInstance().getTime().getTime();
			return (local - remote) <= 5 * 60 * 1000L;
		} else {
			return false;
		}
	}

	/**
	 * 检查发起SPI请求的来源IP是否是TOP机房的出口IP。
	 * 
	 * @return true表达IP来源合法，false代表IP来源不合法
	 */
	public static boolean checkRemoteIp(HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		for (String ipHeader : HEADER_FIELDS_IP) {
			String realIp = request.getHeader(ipHeader);
			if (!StringUtils.isEmpty(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
				ip = realIp;
				break;
			}
		}

		return ip.startsWith("140.205.144.") || ip.startsWith("140.205.145.");
	}

}