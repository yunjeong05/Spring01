package com.ezen.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//// 3. 애즈팩즈 설정
//@Aspect
public class BoforeAdvice {
	// 1. 포인트컷 설정 
//	@Pointcut("execution(* com.ezen.spring.service..*Impl.*(..))")
//	public void allPointcut() {}
//	
//	@Pointcut("execution(* com.ezen.spring.service..*get.*(..))")
//	public void getPointcut() {}
		
	// 2. 어드바이스 설정 
	//@Before("allPointcut()")
	//       외부(PointcutCommon)에 포인트컷을 설정해 놓고 호출해서 사용하는 방법 
	@Before("PointcutCommon.allPointcut()")
	public void beforeMethod(JoinPoint jp) {		
		String methodName = jp.getSignature().getName();
		Object[] methodArgs = jp.getArgs();
		
		System.out.println("[사전 처리]" + methodName + "()메소드 ARGS 정보:" + methodArgs[0].toString());
	};

}
