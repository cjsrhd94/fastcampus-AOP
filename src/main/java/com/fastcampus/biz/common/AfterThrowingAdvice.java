package com.fastcampus.biz.common;

import org.aspectj.lang.JoinPoint;

import java.sql.SQLException;

public class AfterThrowingAdvice {

    // JoinPoint가 다른 매개변수와 같이 사용되는 경우, 반드시 첫 번째 매개변수로 선언되어야 한다.
    public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
        String method = jp.getSignature().getName();
        System.out.println("[ 예외 처리 ] " + method +
                "() 메소드 수행중 예외 발생 : " + exceptionObj.getMessage());

        // 발생된 예외의 타입에 따라 예외처리 로직을 분기시킨다.
        if (exceptionObj instanceof IllegalArgumentException) {
            System.out.println("0번 글을 등록할 수는 없습니다.");
        } else if (exceptionObj instanceof ArithmeticException) {
            System.out.println("0으로 숫자를 나눌 수는 없습니다.");
        } else if (exceptionObj instanceof SQLException) {
            System.out.println("SQL 구문에 오류가 있습니다.");
        } else {
            System.out.println("시스템에 예상치 못한 오류가 발생했습니다.");
        }
    }
}
