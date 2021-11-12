package com.fastcampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Aspect
public class AfterThrowingAdvice {

    @Pointcut("execution(* com.fastcampus.biz..*Impl.*(..))")
    public void allPointcut() {
    }

    // JoinPoint�� �ٸ� �Ű������� ���� ���Ǵ� ���, �ݵ�� ù ��° �Ű������� ����Ǿ�� �Ѵ�.
    @AfterThrowing(pointcut = "allPointcut()", throwing = "exceptionObj")
    public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
        String method = jp.getSignature().getName();
        System.out.println("[ ���� ó�� ] " + method +
                "() �޼ҵ� ������ ���� �߻� : " + exceptionObj.getMessage());

        // �߻��� ������ Ÿ�Կ� ���� ����ó�� ������ �б��Ų��.
        if (exceptionObj instanceof IllegalArgumentException) {
            System.out.println("0�� ���� ����� ���� �����ϴ�.");
        } else if (exceptionObj instanceof ArithmeticException) {
            System.out.println("0���� ���ڸ� ���� ���� �����ϴ�.");
        } else if (exceptionObj instanceof SQLException) {
            System.out.println("SQL ������ ������ �ֽ��ϴ�.");
        } else {
            System.out.println("�ý��ۿ� ����ġ ���� ������ �߻��߽��ϴ�.");
        }
    }
}
