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

    // Around�� ��ϵǴ� �޼ҵ常 ProceedingJoinPoint�� �ް�,
    // �������� JoinPoint�� �޾ƾ� �Ѵ�.
    @Before("allPointcut()")
    public void beforeLog(JoinPoint jp) {
        String method = jp.getSignature().getName();

        // JoinPoint�� getArgs() �޼ҵ带 �̿��ϸ� ����Ͻ� �޼ҵ� ȣ�� �� ���޵� ���� �� �� �ִ�.
        Object[] args = jp.getArgs();

        System.out.println("[ ���� ó�� ] " + method +
                "() �޼ҵ� ARGS ���� : " + args[0].toString());
    }

    @AfterReturning(pointcut = "getPointcut()", returning = "returnObj")
    public void afterLog(JoinPoint jp, Object returnObj){
        String method = jp.getSignature().getName();

        System.out.println("[ ���� ó�� ] " + method +
                "() �޼ҵ��� ���� �� : " + returnObj.toString());

        // ����Ͻ� �޼ҵ尡 ������ ��ü�� UserVo Ÿ���� ��ü���� Ȯ��
        if (returnObj instanceof UserVO){
            // UserVO Ÿ���� ��ü�� ���ϵƴٸ� UserVO Ÿ������ ����ȯ
            UserVO user = (UserVO) returnObj;
            // ADMIN ������ ���� ����ڰ� �˻� �ƴ��� Ȯ��
            if(user.getRole().equals("ADMIN")){
                // ������ ������������ �����Ѵ�.
                System.out.println(user.getName() + " �����ڴ� ������ ������������ �̵��մϴ�.");
            }
        }
    }
}
