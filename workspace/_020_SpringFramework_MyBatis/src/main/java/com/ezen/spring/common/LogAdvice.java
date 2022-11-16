package com.ezen.spring.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
// 서비스 애즈팩즈 주석처리 너무 많은 찍혀서 
//@Service
//3.애즈팩트 설정
//@Aspect 사용 시 클래스 안의 포인트컷과 어드바이스가 결합되어 자동적으로 실행하게 된다. 
//@Aspect
public class LogAdvice {
	//1. 포인트컷 설정 
	@Pointcut("execution(* com.ezen.spring.service..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.ezen.spring.service..*get.*(..))")
	public void getPointcut() {}
	
	// 2. 어드바이스 설정: AOP의 시점을 어노테이션으로 매개변수로 포인트컷 메소드명을 넣어준다.  
	// @Before @afterReturning @Afterthrowing, @After, @Around
	//      호출될 함수명 
	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[공통 로그] 비지니스 로직 전 실행");
	}
	
	
}
