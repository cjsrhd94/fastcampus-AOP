package com.fastcampus.biz.common;

import com.fastcampus.biz.user.UserVO;
import org.aspectj.lang.JoinPoint;

public class AfterReturningAdvice {

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
