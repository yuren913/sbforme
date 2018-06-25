package com.forme.sbforme.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.forme.sbforme.controller.GirlController.*(..))")
    public void logIt(){

    }

    @Before("logIt()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //client ip
        logger.info("ip={}",request.getRemoteAddr());

        //class name
        logger.info("class method={}", joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName());

        //parameters
        logger.info("class parameters={}", joinPoint.getArgs());



    }

    @After("logIt()")
    public void doAfter(){
        logger.info("log after");
    }


    @AfterReturning(returning = "object", pointcut = "logIt()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }

}
