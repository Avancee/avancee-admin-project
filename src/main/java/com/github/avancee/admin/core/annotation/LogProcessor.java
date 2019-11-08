package com.github.avancee.admin.core.annotation;

import com.alibaba.fastjson.JSON;
import com.github.avancee.admin.util.PrincipalUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * LogProcessor
 *
 * @see LogProcessor
 * @author byference
 * @since 2019-11-08
 */
@Slf4j
@Aspect
@Component
public class LogProcessor {

    @Around("@annotation(com.github.avancee.admin.core.annotation.Log)")
    public Object joinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String args = JSON.toJSONString(joinPoint.getArgs());
        String currentUserName = PrincipalUtil.getCurrentUserName();
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();
        long costTime = System.currentTimeMillis() - start;
        log.info("currentUser: [{}], {}#{} args: {} , 执行耗时: {} ms", currentUserName, className, methodName, args, costTime);
        return proceed;
    }

}
