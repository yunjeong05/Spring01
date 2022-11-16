package com.ezen.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. 스프링 컨테이너 구동
		// 스프링 컨테이너 객체 생성                       
		AbstractApplicationContext factory = 
				//어떤 파일을 읽어서 스프링 컨테이너를 구동할 지 -> root-context.xml파일 읽어서 구동
				new GenericXmlApplicationContext("root-context.xml");
		
		// 2. DL과 DI (어떤 식으로 일어나는 지)
		// DL(Dependency Lookup): sTv라는 id를 가진 bean 객체를 찾음
		// DI(Dependency Injection): DL에서 찾은 Bean 객체를 tv에 의존성 주입
		// lazy-init 속성이 true일 때는 getBean으로 해당객체를 요청하면 객체 생성. 
//		TV tv = (TV)factory.getBean("sTv"); // TV 객체 생성, "아이디"값으로 꺼내 올 수 있다. 형변환 해줘야함 (getBean은 Object타입)
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();		

		TV tv1 = (TV)factory.getBean("sTv"); // TV 객체 생성, "아이디"값으로 꺼내 올 수 있다. 형변환 해줘야함 (getBean은 Object타입)
		tv1.powerOn();
		tv1.volumeUp();  // 소니스피커 객체 생성 
 		tv1.volumeDown(); // 소니스피커 객체 생성  
		tv1.powerOff();		
		
		// 3. 스프링 컨테이너 종료
		factory.close();
	}

}
