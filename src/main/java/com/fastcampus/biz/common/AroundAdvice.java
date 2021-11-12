package com.fastcampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {

    // ������ �޼ҵ�� ��� ó���� ���� �޼ҵ尡 �ƴ� �ĺ��ڷμ��� ���Ҹ� �����Ѵ�.
    @Pointcut("execution(* com.fastcampus.biz..*Impl.*(..))")
    public void allPointcut() {
    }

    @Around("allPointcut()")
    public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
        // JoinPoint�� ����� ProceedingJoinPoint�� �̿��ϸ� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼ҵ� ������ �� �� �ִ�.
        String method = jp.getSignature().getName();

        Object returnObj = null;

        StopWatch watch = new StopWatch();
        watch.start();

        // ���� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼ҵ尡 ����Ǵ� ����
        returnObj = jp.proceed();

        watch.stop();

        System.out.println(method + "() �޼ҵ� ���࿡ �ҿ�� �ð� : " + watch.getTotalTimeSeconds() + "(��)");

        return returnObj;
    }
}
