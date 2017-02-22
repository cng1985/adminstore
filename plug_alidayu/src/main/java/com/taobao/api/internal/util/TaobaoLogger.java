package com.taobao.api.internal.util;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 客户端日志记录
 */
public class TaobaoLogger {

	private static final Log log = LogFactory.getLog("topsdk");
	private static final String LOG_SPLIT = "^_^";

	private static String osName = System.getProperties().getProperty("os.name");
	private static boolean needEnableLogger = true;

	public static void setNeedEnableLogger(boolean needEnableLogger) {
		TaobaoLogger.needEnableLogger = needEnableLogger;
	}

	public static void logApiError(String appKey, String apiName, String url, Map<String, String> params, long latency, String errorMessage) {
		if (!needEnableLogger) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(formatDateTime(new Date()));// 时间
		sb.append(LOG_SPLIT);
		sb.append(appKey);// APP
		sb.append(LOG_SPLIT);
		sb.append(apiName);// API
		sb.append(LOG_SPLIT);
		sb.append(TaobaoUtils.getIntranetIp());// IP地址
		sb.append(LOG_SPLIT);
		sb.append(osName);// 操作系统
		sb.append(LOG_SPLIT);
		sb.append(latency);// 延迟时间
		sb.append(LOG_SPLIT);
		sb.append(url);// 请求URL
		try {
			sb.append(LOG_SPLIT);
			sb.append(WebUtils.buildQuery(params, "utf-8"));// 请求参数
		} catch (IOException e) {
		}
		sb.append(LOG_SPLIT);
		sb.append(errorMessage);// 错误信息
		log.error(sb.toString());
	}

	private static String formatDateTime(Date date) {
		return StringUtils.formatDateTime(date, "yyyy-MM-dd HH:mm:ss.SSS");
	}
}
