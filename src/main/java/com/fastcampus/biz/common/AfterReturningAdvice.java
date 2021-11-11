package com.fastcampus.biz.common;

import com.fastcampus.biz.user.UserVO;

public class AfterReturningAdvice {

    public void afterLog(Object returnObj){

        System.out.println("[ 사후 처리] 비즈니스 메소드의 리턴 값 : " + returnObj.toString());

        // 비즈니스 메소드가 리턴한 객체가 UserVo 타입의 객체인지 확인
        if (returnObj instanceof UserVO){
            // UserVO 타입의 객체가 리턴됐다면 UserVO 타입으로 형변환
            UserVO user = (UserVO) returnObj;
            // ADMIN 권한을 가진 사용자가 검색 됐는지 확인
            if(user.getRole().equals("ADMIN")){
                // 관리자 전용페이지를 서비스한다.
                System.out.println(user.getName() + " 관리자님 관리자 전용페이지로 이동합니다.");
            }
        }
    }
}
