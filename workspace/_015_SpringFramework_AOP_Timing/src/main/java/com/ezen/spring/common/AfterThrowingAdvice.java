package com.ezen.spring.common;

public class AfterThrowingAdvice {
	public void afterThrowingMethod() {
		System.out.println("[예외 처리] 비즈니스 로직 중 예외 발생 시 동작");
		//임의로 BoardServiceImpl에서 예외발생 하도록 작성 후 실행해야함
	};

}
