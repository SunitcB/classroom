package com.sunitcb.classroom.aspect;

import com.sunitcb.classroom.domain.ExceptionLog;
import com.sunitcb.classroom.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {
    @Autowired
    ExceptionService exceptionService;

    @Pointcut("execution(* com.sunitcb.classroom.service.impl.PostServiceImpl.*(..))")
    public void exceptionLogger(){}

    @AfterThrowing(value = "exceptionLogger()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Exception error){
        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setDate(LocalDate.now());
        exceptionLog.setTime(LocalTime.now());
        exceptionLog.setOperation(joinPoint.getSignature().getName());
        exceptionLog.setPrinciple("Sunit Bajracharya");
        exceptionLog.setExceptionType(error.toString());
        exceptionService.saveException(exceptionLog);
    }
}
