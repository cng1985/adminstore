package com.taobao.api.internal.cluster;

import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;

public final class ClusterManager {

	private static final Log log = LogFactory.getLog(ClusterManager.class);

	private static final Random random = new Random();
	private static final Object initLock = new Object();
	private static volatile DnsConfig dnsConfig = null;
	private static volatile Thread refreshThread = null;

	public static <T extends Weightable> T getElementByWeight(List<T> list) {
		T selected = null;
		double totalWeight = 0d;
		for (T element : list) {
			double r = random.nextDouble() * (element.getWeight() + totalWeight);
			if (r >= totalWeight) {
				selected = element;
			}
			totalWeight += element.getWeight();
		}
		return selected;
	}

	public static DnsConfig GetDnsConfigFromCache() {
		return dnsConfig;
	}

	public static void initRefreshThread(final TaobaoClient client) throws ApiException {
		if (refreshThread == null) {
			synchronized (initLock) {
				if (refreshThread == null) {
					try {
						dnsConfig = getDnsConfigFromTop(client);
					} catch (ApiException e) {
						if ("22".equals(e.getErrCode())) {
							return; // 如果HTTP DNS服务不存在，则退出守护线程
						} else {
							throw e;
						}
					}

					refreshThread = new Thread(new Runnable() {
						public void run() {
							while (true) {
								try {
									sleep(dnsConfig.getRefreshInterval() * 60 * 1000L);
									dnsConfig = getDnsConfigFromTop(client);
								} catch (Exception e) {
									log.error("refresh http dns config from top fail", e);
									sleep(3 * 1000L); // 出错则过3秒重试
								}
							}
						}
					});
					refreshThread.setDaemon(true);
					refreshThread.setName("HTTP_DNS_REFRESH_THREAD");
					refreshThread.start();
				}
			}
		}
	}

	private static DnsConfig getDnsConfigFromTop(TaobaoClient client) throws ApiException {
		HttpdnsGetRequest req = new HttpdnsGetRequest();
		HttpdnsGetResponse rsp = client.execute(req);
		if (rsp.isSuccess()) {
			return DnsConfig.parse(rsp.getResult());
		} else {
			throw new ApiException(rsp.getErrorCode(), rsp.getMsg());
		}
	}

	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
