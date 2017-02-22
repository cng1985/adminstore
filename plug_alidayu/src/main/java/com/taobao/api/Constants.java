package com.taobao.api;

/**
 * 公用常量类。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public abstract class Constants {

	/** TOP协议入参共享参数 **/
	public static final String APP_KEY = "app_key";
	public static final String FORMAT = "format";
	public static final String METHOD = "method";
	public static final String TIMESTAMP = "timestamp";
	public static final String VERSION = "v";
	public static final String SIGN = "sign";
	public static final String SIGN_METHOD = "sign_method";
	public static final String PARTNER_ID = "partner_id";
	public static final String SESSION = "session";
	public static final String SIMPLIFY = "simplify";
	public static final String TARGET_APP_KEY = "target_app_key";

	/** TOP协议出参共享参数 */
	public static final String ERROR_RESPONSE = "error_response";
	public static final String ERROR_CODE = "code";
	public static final String ERROR_MSG = "msg";
	public static final String ERROR_SUB_CODE = "sub_code";
	public static final String ERROR_SUB_MSG = "sub_msg";

	/** 奇门协议共享参数 */
	public static final String QM_ROOT_TAG = "request";
	public static final String QM_CUSTOMER_ID = "customerId";
	public static final String QM_CONTENT_TYPE = "text/xml;charset=utf-8";

	/** TOP默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** TOP Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	/** UTF-8字符集 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/** GBK字符集 **/
	public static final String CHARSET_GBK = "GBK";

	/** TOP JSON 应格式 */
	public static final String FORMAT_JSON = "json";
	/** TOP XML 应格式 */
	public static final String FORMAT_XML = "xml";

	/** MD5签名方式 */
	public static final String SIGN_METHOD_MD5 = "md5";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_HMAC = "hmac";

	/** SDK版本号 */
	public static final String SDK_VERSION = "top-sdk-java-20160607";

	/** 异步多活SDK版本号 */
	public static final String SDK_VERSION_CLUSTER = "top-sdk-java-cluster-20160607";

	/** 响应编码 */
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	public static final String CONTENT_ENCODING = "Content-Encoding";
	public static final String CONTENT_ENCODING_GZIP = "gzip";

	/** 默认媒体类型 **/
	public static final String MIME_TYPE_DEFAULT = "application/octet-stream";

	/** 默认流式读取缓冲区大小 **/
	public static final int READ_BUFFER_SIZE = 1024 * 4;
	
}
