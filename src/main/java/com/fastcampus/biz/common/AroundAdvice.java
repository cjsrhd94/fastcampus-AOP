package com.fastcampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service("around")
public class AroundAdvice {

    public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{
        Object returnObj = null;

        StopWatch watch = new StopWatch();
        watch.start();

        // 실제 클라이언트가 호출한 비즈니스 메소드가 실행되는 시점
        returnObj =jp.proceed();

        watch.stop();

        System.out.println("비즈니스 메소드 수행에 소요된 시간 : " + watch.getTotalTimeSeconds() + "(초)");

        return returnObj;
    }
}
