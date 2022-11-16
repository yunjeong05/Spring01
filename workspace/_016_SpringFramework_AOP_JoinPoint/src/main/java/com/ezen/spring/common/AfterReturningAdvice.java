package com.ezen.spring.common;

import org.aspectj.lang.JoinPoint;

import com.ezen.spring.vo.UserVO;

public class AfterReturningAdvice {
	// returnObj: 포인트컷 메소드가 종료될 때 반환해주는 반환값
	// 두번째 인자인 Object를 바인드 변수라고 하고 메소드에 리턴값을 자동으로 매핑해준다. 리턴값이 어떤 형태로 나올지몰라 Object로 받아 후처리를 한다. 
	public void afterReturningMethod(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getId().equals("admin")) {
				System.out.println(user.getName() + " 로그인(admin)");
			}
		}
		
		System.out.println("[사후 처리]" + methodName + "() 리턴 값:" + returnObj.toString());
		
	};

}
