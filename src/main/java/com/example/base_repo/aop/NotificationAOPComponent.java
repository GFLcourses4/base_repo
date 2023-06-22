package com.example.base_repo.aop;

import com.example.base_repo.decorator.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class NotificationAOPComponent {

    private final static Logger LOGGER = LoggerFactory.getLogger(NotificationAOPComponent.class);
    @Pointcut(value = "execution (* *.aopNotificationExample(..))")
    public void notificationMethod() {
    }

    @Around("@annotation(org.springframework.stereotype.Component) && notificationMethod() && args(message)")
    public Object executionTime(ProceedingJoinPoint joinPoint, String message) throws Throwable {
        long start = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long end = System.nanoTime();
        LOGGER.info("Execution time - " + TimeUnit.NANOSECONDS.toMillis(end - start));
        return proceed;
    }

    @AfterThrowing(value = "notificationMethod()", throwing = "e")
    public void executionThrow(Exception e) throws Throwable {
        LOGGER.error("AOP exception handling -> " + e.getMessage());
    }
}
