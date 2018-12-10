package com.quhaodian.adminstore.data.apps;

import jodd.http.HttpRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoApp {

  private static AtomicInteger count = new AtomicInteger();

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 10000000; i++) {
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println(count.addAndGet(1));
          String body = HttpRequest.get("http://localhost:8080/web/rest/member/demo.htm").send().charset("utf8").bodyText();
          System.out.println(body);
        }
      });
    }
    Thread.sleep(100000);
  }
}
