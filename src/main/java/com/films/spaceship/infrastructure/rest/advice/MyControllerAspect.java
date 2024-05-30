package com.films.spaceship.infrastructure.rest.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyControllerAspect {

    @Pointcut(value = "com.films.spaceship.infrastructure.adapters.getById")
    public void getById(){
    }

    @Before("getById")
    public void apiRequestLog(JoinPoint jp){
        log.info(jp.getSignature().getDeclaringTypeName());
    }

    @AfterReturning("getById")
    public void apiResponseLog(JoinPoint jp){
        log.info(jp.getSignature().getDeclaringTypeName());
    }

    @AfterThrowing("getById")
    public void apiResponseExceptionLog(JoinPoint jp){
        log.error(jp.getSignature().getDeclaringTypeName());
    }
}
