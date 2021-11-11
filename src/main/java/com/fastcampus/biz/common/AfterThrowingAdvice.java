package com.fastcampus.biz.common;

import java.sql.SQLException;

public class AfterThrowingAdvice {

    public void exceptionLog(Exception exceptionObj) {

        System.out.println("[ ���� ó�� ] ����Ͻ� �޼ҵ��� ���� �� : " + exceptionObj.getMessage());

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
