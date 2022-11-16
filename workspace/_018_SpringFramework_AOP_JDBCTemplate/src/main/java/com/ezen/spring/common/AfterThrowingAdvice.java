package com.ezen.spring.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void afterThrowingMethod(JoinPoint jp, Exception exceptObj) {
		String methodName= jp.getSignature().getName();	
		
		System.out.println("[예외 처리]" + methodName +"()실행 중 발생한 예외 메세지: " + exceptObj.getMessage());
		//임의로 BoardServiceImpl에서 예외발생 하도록 작성 후 실행해야함
	};

}
