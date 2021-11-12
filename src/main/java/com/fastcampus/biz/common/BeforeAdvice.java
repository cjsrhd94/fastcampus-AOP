package com.fastcampus.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

    // Around로 등록되는 메소드만 ProceedingJoinPoint를 받고,
    // 나머지는 JoinPoint를 받아야 한다.
    public void beforeLog(JoinPoint jp) {
        String method = jp.getSignature().getName();

        // JoinPoint의 getArgs() 메소드를 이용하면 비즈니스 메소드 호출 시 전달된 값을 얻어낼 수 있다.
        Object[] args = jp.getArgs();

        System.out.println("[ 사전 처리 ] " + method +
                "() 메소드 ARGS 정보 : " + args[0].toString());
    }
}
