package ru.ryabtsev.enterprise.controller;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Simple logger.
 */
public class LogInterceptor {
    @AroundInvoke
    public Object printLog(InvocationContext ctx) throws Exception {
        System.out.println("[LOGGER] Method called: " + ctx.getMethod().getName());

        return ctx.proceed();
    }

}
