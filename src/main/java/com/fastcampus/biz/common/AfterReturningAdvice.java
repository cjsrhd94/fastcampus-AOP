package com.fastcampus.biz.common;

import com.fastcampus.biz.user.UserVO;

public class AfterReturningAdvice {

    public void afterLog(Object returnObj){

        System.out.println("[ ���� ó��] ����Ͻ� �޼ҵ��� ���� �� : " + returnObj.toString());

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
