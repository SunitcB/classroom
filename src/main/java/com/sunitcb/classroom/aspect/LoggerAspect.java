package com.sunitcb.classroom.aspect;

import com.sunitcb.classroom.domain.Logger;
import com.sunitcb.classroom.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    LoggerService loggerService;

    @Pointcut("execution(* com.sunitcb.classroom.controller.PostController.*(..))")
    public void logExecution() {
    }

    @AfterReturning("logExecution()")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("*********************************");
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple("Sunit Bajracharya");
        logger.setOperation(joinPoint.getSignature().getName());
        loggerService.saveLog(logger);
    }
}
