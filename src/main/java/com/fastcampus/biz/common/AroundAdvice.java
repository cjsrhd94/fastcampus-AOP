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

        // ���� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼ҵ尡 ����Ǵ� ����
        returnObj =jp.proceed();

        watch.stop();

        System.out.println("����Ͻ� �޼ҵ� ���࿡ �ҿ�� �ð� : " + watch.getTotalTimeSeconds() + "(��)");

        return returnObj;
    }
}
