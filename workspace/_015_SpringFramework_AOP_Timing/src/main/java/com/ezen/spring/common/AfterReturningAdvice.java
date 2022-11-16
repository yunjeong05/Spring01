package com.ezen.spring.common;

public class AfterReturningAdvice {
	public void afterReturningMethod() {
		System.out.println("[사후 처리] 비지니스 로직 정상 종료시 동작");
	};

}
