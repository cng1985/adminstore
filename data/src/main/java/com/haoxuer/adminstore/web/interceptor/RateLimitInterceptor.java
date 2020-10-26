package com.haoxuer.adminstore.web.interceptor;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RateLimitInterceptor extends HandlerInterceptorAdapter {

    public static final int REQUEST_COUNT = 1;
    /*** set the number of requests per second */
    private static final RateLimiter rateLimiter = RateLimiter.create(REQUEST_COUNT);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!rateLimiter.tryAcquire()) {
            System.out.println(">>>>>>>>>> 亲！请稍后重试！");
            return false;
        }
        System.out.println(">>>>>>>> 恭喜您下单成功！");
        return true;
    }
}
