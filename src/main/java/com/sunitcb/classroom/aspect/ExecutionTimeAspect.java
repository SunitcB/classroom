package com.sunitcb.classroom.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(com.sunitcb.classroom.annotation.ExecutionTime)")
    public void logTime(){}

    @Around("logTime()")
    public void getLogTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.nanoTime();
        proceedingJoinPoint.proceed();
        long finishTime = System.nanoTime();
        System.out.println("The method " + proceedingJoinPoint.getSignature().getName() + " takes " + (finishTime - startTime) +" ms");
    }
}
