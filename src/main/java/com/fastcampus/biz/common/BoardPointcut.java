package com.fastcampus.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoardPointcut {

    // 참조용 메소드는 기능 처리를 위한 메소드가 아닌 식별자로서의 역할만 수행한다.
    @Pointcut("execution(* com.fastcampus.biz..*Impl.*(..))")
    public void allPointcut() {
    }

    @Pointcut("execution(* com.fastcampus.biz..*Impl.get*(..))")
    public void getPointcut() {
    }

    @Pointcut("execution(* com.fastcampus.biz.board.*Impl.*(..))")
    public void boardPointcut() {
    }

    @Pointcut("execution(* com.fastcampus.biz.user.*Impl.*(..))")
    public void userPointcut() {
    }
}
