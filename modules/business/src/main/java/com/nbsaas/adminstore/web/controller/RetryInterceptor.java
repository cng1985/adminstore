/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nbsaas.adminstore.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Daniel Meyer
 */
public class RetryInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RetryInterceptor.class);

    protected int numOfRetries = 3;
    protected int waitTimeInMs = 50;
    protected int waitIncreaseFactor = 5;

    public static AtomicLong num=new AtomicLong();

    public void execute(Runnable command) {
        long waitTime = waitTimeInMs;
        int failedAttempts = 0;

        do {
            if (failedAttempts > 0) {
                log.info("Waiting for {}ms before retrying the command.", waitTime);
                waitBeforeRetry(waitTime);
                waitTime *= waitIncreaseFactor;
            }
            try {
                long time=System.currentTimeMillis();
                command.run();
                time=System.currentTimeMillis()-time;
                time=time/1000;
                if (time>3){
                    num.getAndAdd(1L);
                    log.info("时间过长,用时:"+time+"秒"+",一共:"+num.get()+"次");
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Caught optimistic locking exception: " + e);
                failedAttempts++;
            }

        } while (failedAttempts <= numOfRetries);

    }

    protected void waitBeforeRetry(long waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            log.debug("I am interrupted while waiting for a retry.");
        }
    }

    public void setNumOfRetries(int numOfRetries) {
        this.numOfRetries = numOfRetries;
    }

    public void setWaitIncreaseFactor(int waitIncreaseFactor) {
        this.waitIncreaseFactor = waitIncreaseFactor;
    }

    public void setWaitTimeInMs(int waitTimeInMs) {
        this.waitTimeInMs = waitTimeInMs;
    }

    public int getNumOfRetries() {
        return numOfRetries;
    }

    public int getWaitIncreaseFactor() {
        return waitIncreaseFactor;
    }

    public int getWaitTimeInMs() {
        return waitTimeInMs;
    }
}
