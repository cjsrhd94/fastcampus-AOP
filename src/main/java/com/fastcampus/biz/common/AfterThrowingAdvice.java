package com.fastcampus.biz.common;

import org.aspectj.lang.JoinPoint;

import java.sql.SQLException;

public class AfterThrowingAdvice {

    // JoinPoint�� �ٸ� �Ű������� ���� ���Ǵ� ���, �ݵ�� ù ��° �Ű������� ����Ǿ�� �Ѵ�.
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
