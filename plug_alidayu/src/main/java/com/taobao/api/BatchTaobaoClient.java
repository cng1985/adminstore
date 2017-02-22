package com.taobao.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.taobao.api.internal.parser.json.ObjectJsonParser;
import com.taobao.api.internal.parser.xml.ObjectXmlParser;
import com.taobao.api.internal.util.RequestParametersHolder;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.TaobaoLogger;
import com.taobao.api.internal.util.TaobaoUtils;
import com.taobao.api.internal.util.WebUtils;

/**
 * 批量API请求客户端。
 * 
 * @author fengsheng
 * @since Jan 8, 2016
 */
public class BatchTaobaoClient extends DefaultTaobaoClient {

    public static final String BATCH_API_HEADER_SPLIT = "top-api-separator"; // 批量API用户自定义分隔符Header Key
    public static final String BATCH_API_PUBLIC_PARAMETER = "#PUBLIC#"; // 批量API公共参数头
	public static final String BATCH_API_DEFAULT_SPLIT = "\r\n-S-\r\n";// 批量API默认分隔符

	private String batchServerUrl;
	private String batchApiSeparator; // 自定义批量API分隔符

	public BatchTaobaoClient(String serverUrl, String appKey, String appSecret) {
		super(buildApiServerUrl(serverUrl), appKey, appSecret);
		this.batchServerUrl = serverUrl;
	}

	public BatchTaobaoClient(String serverUrl, String appKey, String appSecret, String format) {
		super(buildApiServerUrl(serverUrl), appKey, appSecret, format);
		this.batchServerUrl = serverUrl;
	}

	public BatchTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) {
		super(buildApiServerUrl(serverUrl), appKey, appSecret, format, connectTimeout, readTimeout);
		this.batchServerUrl = serverUrl;
	}

	public BatchTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) {
		super(buildApiServerUrl(serverUrl), appKey, appSecret, format, connectTimeout, readTimeout, signMethod);
		this.batchServerUrl = serverUrl;
	}

	/**
	 * 设置批量API请求的自定义分隔符。
	 */
	public void setBatchApiSeparator(String batchApiSeparator) {
		this.batchApiSeparator = batchApiSeparator;
	}

	/**
	 * 执行批量API请求。
	 * 
	 * @param <T> 具体的API响应类
	 * @param request 批量API请求类（线程不安全，不能把此请求重复使用，否则将会出现响应顺序错乱）
	 * @return 批量API响应类，单个API响应顺序与请求一致
	 */
	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) throws ApiException {
		return execute(request, null);
	}

	/**
	 * 执行批量隐私API请求。
	 * 
	 * @param <T> 具体的API响应类
	 * @param request 批量API请求类（线程不安全，不能把此请求重复使用，否则将会出现响应顺序错乱）
	 * @param session 用户授权码，将会用于所有批量API请求的授权码，但可以被单个API请求的授权码覆盖
	 * @return 批量API响应类，单个API响应顺序与请求一致
	 */
	public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request, String session) throws ApiException {
		if (request instanceof TaobaoBatchRequest) {
			return _execute(request, session);
		} else {
			return super.execute(request, session);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T extends TaobaoResponse> T _execute(TaobaoRequest<T> tRequest, String session) throws ApiException {
		TaobaoBatchRequest batchRequest = (TaobaoBatchRequest) tRequest;
		long start = System.currentTimeMillis();

		List<TaobaoRequest<?>> requestList = batchRequest.getRequestList();
		if (requestList == null || requestList.isEmpty()) {
			throw new ApiException("40", "client-error:api request list is empty");
		}

		// 本地校验请求参数
		if (this.needCheckRequest && batchRequest.getPublicParams().isEmpty()) {
			for (int i = 0; i < requestList.size(); i++) {
				try {
					requestList.get(i).check();
				} catch (ApiRuleException e) {
					return (T) new TaobaoBatchResponse(e.getErrCode(), "API NO. " + (i + 1) + ": " + e.getErrMsg());
				}
			}
		}

		// 添加协议级请求参数
		RequestParametersHolder requestHolder = new RequestParametersHolder();
		TaobaoHashMap protocalMustParams = new TaobaoHashMap();
		protocalMustParams.put(Constants.VERSION, "2.0");
		protocalMustParams.put(Constants.APP_KEY, appKey);
		Long timestamp = batchRequest.getTimestamp();
		if (timestamp == null) {
			timestamp = System.currentTimeMillis();
		}
		protocalMustParams.put(Constants.TIMESTAMP, new Date(timestamp));
		requestHolder.setProtocalMustParams(protocalMustParams);

		TaobaoHashMap protocalOptParams = new TaobaoHashMap();
		protocalOptParams.put(Constants.FORMAT, format);
		protocalOptParams.put(Constants.SIGN_METHOD, signMethod);
		protocalOptParams.put(Constants.SESSION, session);
		protocalOptParams.put(Constants.PARTNER_ID, getSdkVersion());
		protocalOptParams.put(Constants.TARGET_APP_KEY, batchRequest.getTargetAppKey());
		if (Constants.FORMAT_JSON.equals(format) && this.useSimplifyJson) {
			protocalOptParams.put(Constants.SIMPLIFY, Boolean.TRUE.toString());
		}
		requestHolder.setProtocalOptParams(protocalOptParams);

		// 添加自定义分隔符
		String separator = BATCH_API_DEFAULT_SPLIT;
		if (batchApiSeparator != null) {
			batchRequest.putHeaderParam(BATCH_API_HEADER_SPLIT, separator = batchApiSeparator);
		}
		// 是否需要压缩响应
		if (this.useGzipEncoding) {
			batchRequest.putHeaderParam(Constants.ACCEPT_ENCODING, Constants.CONTENT_ENCODING_GZIP);
		}

		try {
			// 添加公共请求头
			if (batchRequest.getPublicMethod() != null) {
				batchRequest.addPublicParam(Constants.METHOD, batchRequest.getPublicMethod());
			} else {
				if (isSameRequest(requestList)) {
					batchRequest.addPublicParam(Constants.METHOD, requestList.get(0).getApiMethodName());
				}
			}

			// 构建批量请求主体
			StringBuilder requestBody = new StringBuilder();
			String publicParamStr = WebUtils.buildQuery(batchRequest.getPublicParams(), Constants.CHARSET_UTF8);
			if (!StringUtils.isEmpty(publicParamStr)) {
				requestBody.append(BATCH_API_PUBLIC_PARAMETER).append(publicParamStr).append(separator);
			}

			// 组装每个API的请求参数
			for (int i = 0; i < requestList.size(); i++) {
				TaobaoRequest<?> request = requestList.get(i);
				request.setBatchApiOrder(i);
				Map<String, String> apiParams = request.getTextParams();
				// 如果单个API的方法和批量API的公共方法不一致，那么需要设置单个API的方法名称
				if (request.getApiMethodName() != null && !request.getApiMethodName().equals(batchRequest.getPublicMethod())) {
					apiParams.put(Constants.METHOD, request.getApiMethodName());
				}
				if (request.getBatchApiSession() != null) {
					apiParams.put(Constants.SESSION, request.getBatchApiSession());
				}
				if (request.getTargetAppKey() != null) {
					apiParams.put(Constants.TARGET_APP_KEY, request.getTargetAppKey());
				}
				String apiParamStr = WebUtils.buildQuery(apiParams, Constants.CHARSET_UTF8);
				if (StringUtils.isEmpty(apiParamStr)) {
					apiParamStr = "N";
				}
				requestBody.append(apiParamStr);
				if (i != (requestList.size() - 1)) {
					requestBody.append(separator);
				}
			}

			String apiBody = requestBody.toString();

			// 添加签名参数
			protocalMustParams.put(Constants.SIGN, TaobaoUtils.signTopRequestWithBody(requestHolder, apiBody, appSecret, signMethod));

			// 发起批量请求
			String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), Constants.CHARSET_UTF8);
			String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), Constants.CHARSET_UTF8);
			String fullUrl = WebUtils.buildRequestUrl(this.batchServerUrl, sysMustQuery, sysOptQuery);
            String rsp = WebUtils.doPost(fullUrl, apiBody, Constants.CHARSET_UTF8, connectTimeout, readTimeout, batchRequest.getHeaderMap());
            requestHolder.setResponseBody(rsp);
        } catch (IOException e) {
            TaobaoLogger.logApiError(appKey, "BatchApi", batchServerUrl, requestHolder.getAllParams(), System.currentTimeMillis() - start, e.toString());
            throw new ApiException(e);
		}

		// 构造响应解释器
		List<TaobaoParser<?>> parserList = new ArrayList<TaobaoParser<?>>();
		if (this.needEnableParser) {
			if (Constants.FORMAT_XML.equals(this.format)) {
				for (int i = 0; i < requestList.size(); i++) {
					parserList.add(new ObjectXmlParser(requestList.get(i).getResponseClass()));
				}
			} else {
				for (int i = 0; i < requestList.size(); i++) {
					parserList.add(new ObjectJsonParser(requestList.get(i).getResponseClass(), this.useSimplifyJson));
				}
			}
		}

		TaobaoBatchResponse batchResponse = new TaobaoBatchResponse();
		batchResponse.setBody(requestHolder.getResponseBody());

		String[] responseArray = batchResponse.getBody().split(separator);
		// 批量API在走单通道验证时没通过，如前面验证，此时只有一个报错信息
		if (responseArray.length > 0 && responseArray.length != requestList.size()) {
			if (this.needEnableParser) {
				TaobaoResponse tRsp = (TaobaoResponse) parserList.get(0).parse(responseArray[0]);
				batchResponse.setErrorCode(tRsp.getErrorCode());
				batchResponse.setMsg(tRsp.getMsg());
				batchResponse.setSubCode(tRsp.getSubCode());
				batchResponse.setSubMsg(tRsp.getSubMsg());
			} else {
				batchResponse.setMsg("batch api call fail");
			}
			return (T) batchResponse;
		}

		for (int i = 0; i < responseArray.length; i++) {
			TaobaoResponse tRsp = null;
			if (this.needEnableParser) {
				tRsp = (TaobaoResponse) parserList.get(i).parse(responseArray[i]);
				tRsp.setBody(responseArray[i]);
			} else {
				try {
					tRsp = requestList.get(i).getResponseClass().newInstance();
					tRsp.setBody(responseArray[i]);
				} catch (Exception e) {
					throw new ApiException(e);
				}
			}
			tRsp.setParams(requestList.get(i).getTextParams());
			batchResponse.addResponse(tRsp);
		}

		if (!batchResponse.isSuccess()) {
			TaobaoLogger.logApiError(appKey, "BatchApi", batchServerUrl, requestHolder.getAllParams(), System.currentTimeMillis() - start, batchResponse.getBody());
		}
		return (T) batchResponse;
	}

	/**
	 * 判断批量API请求是否全部请求同一种类型的API。
	 */
	private boolean isSameRequest(List<TaobaoRequest<?>> requestList) {
		if (requestList != null && requestList.size() > 1) { // 只有两个或以上的请求才考虑合并
			String firstMethod = requestList.get(0).getApiMethodName();
			for (int i = 1; i < requestList.size(); i++) {
				String currentMethod = requestList.get(i).getApiMethodName();
				if (!firstMethod.equals(currentMethod)) {
					return false;
				}
			}
		}
		return true;
	}

	private static String buildApiServerUrl(String batchServerUrl) {
		if (batchServerUrl.contains("/router/batch")) {
			return batchServerUrl.replace("/router/batch", "/router/rest");
		}
		return batchServerUrl;
	}

}
