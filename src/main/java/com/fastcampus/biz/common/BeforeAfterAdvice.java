package com.fastcampus.biz.common;

import com.fastcampus.biz.user.UserVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAfterAdvice {

    @Pointcut("execution(* com.fastcampus.biz..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* com.fastcampus.biz..*Impl.get*(..))")
    public void getPointcut() {
    }

    // Around로 등록되는 메소드만 ProceedingJoinPoint를 받고,
    // 나머지는 JoinPoint를 받아야 한다.
    @Before("allPointcut()")
    public void beforeLog(JoinPoint jp) {
        String method = jp.getSignature().getName();

        // JoinPoint의 getArgs() 메소드를 이용하면 비즈니스 메소드 호출 시 전달된 값을 얻어낼 수 있다.
        Object[] args = jp.getArgs();

        System.out.println("[ 사전 처리 ] " + method +
                "() 메소드 ARGS 정보 : " + args[0].toString());
    }

    @AfterReturning(pointcut = "getPointcut()", returning = "returnObj")
    public void afterLog(JoinPoint jp, Object returnObj){
        String method = jp.getSignature().getName();

        System.out.println("[ 사후 처리 ] " + method +
                "() 메소드의 리턴 값 : " + returnObj.toString());

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
