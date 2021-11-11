package com.fastcampus.biz.common;

import java.sql.SQLException;

public class AfterThrowingAdvice {

    public void exceptionLog(Exception exceptionObj) {

        System.out.println("[ 예외 처리 ] 비즈니스 메소드의 리턴 값 : " + exceptionObj.getMessage());

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
