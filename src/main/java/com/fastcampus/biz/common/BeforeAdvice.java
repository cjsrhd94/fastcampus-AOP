package com.fastcampus.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

    // Around�� ��ϵǴ� �޼ҵ常 ProceedingJoinPoint�� �ް�,
    // �������� JoinPoint�� �޾ƾ� �Ѵ�.
    public void beforeLog(JoinPoint jp) {
        String method = jp.getSignature().getName();

        // JoinPoint�� getArgs() �޼ҵ带 �̿��ϸ� ����Ͻ� �޼ҵ� ȣ�� �� ���޵� ���� �� �� �ִ�.
        Object[] args = jp.getArgs();

        System.out.println("[ ���� ó�� ] " + method +
                "() �޼ҵ� ARGS ���� : " + args[0].toString());
    }
}
