package com.albaraka.train.core.exception;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExceptionLoggingAspect {


    private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionLoggingAspect.class);

    @AfterThrowing(pointcut = "within(@org.springframework.stereotype.Service *)", throwing = "ex")
    public void logServiceError(JoinPoint jp, Throwable ex) {
        String svc = jp.getSignature().toShortString();
        logger.error("[SERVICE ERROR] {} threw {}", svc, ex.toString());
    }

}
