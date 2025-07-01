package com.albaraka.train.core.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class RestLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(RestLoggingAspect.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {}

    @Around("restController()")
    public Object logRestCall(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        // 1) Gelen argümanları JSON olarak logla
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            try {
                String argsJson = objectMapper.writeValueAsString(args);
                logger.info("[REQUEST] {}.{}() → args={}", className, methodName, argsJson);
            } catch (Exception e) {
                logger.warn("[REQUEST] {}.{}() → args logging failed: {}", className, methodName, e.getMessage());
            }
        } else {
            logger.info("[REQUEST] {}.{}() → no args", className, methodName);
        }

        // 2) Metodu çalıştır ve sonucu al
        Object result = pjp.proceed();

        // 3) Dönen değeri JSON olarak logla
        if (result != null) {
            try {
                String resJson = objectMapper.writeValueAsString(result);
                logger.info("[RESPONSE] {}.{}() ← result={}", className, methodName, resJson);
            } catch (Exception e) {
                logger.warn("[RESPONSE] {}.{}() ← result logging failed: {}", className, methodName, e.getMessage());
            }
        } else {
            logger.info("[RESPONSE] {}.{}() ← null", className, methodName);
        }

        return result;
    }

}
