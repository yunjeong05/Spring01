package com.ezen.spring.polymorphism;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("lTv")
public class LgTV implements TV {
	// 의존성 주입이 필요한 객체 위에 선언 (생성될 객체)
	// Speaker 모양의 객체를 찾아서 의존성 주입
	// 스프링 컨테이너가 생성한 객체 중에서 Speaker모양의 객체를 찾아 의존성을 주입한다.
	// 어노테이션을 이용한 DI에서는 생성자와 세터 함수를 이용하는 것이 불가능. 
	// @Autowired 사용 시 문제점 같은 모양의 객체가 두 개 이상 존재할 때는 무조건 에러 발생 
	//@Autowired
	//@Qualifier("apple")
	//@Resource = @Autowired + @Qualifier
	@Resource(name="apple")
	Speaker speaker;
	
	// 기본생성자
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}	
	@Override
	public void powerOn(){
		System.out.println("LgTV -- 전원 켜기");
	}
	@Override
	public void powerOff(){
		System.out.println("LgTV -- 전원 끄기");
	}
	@Override
	public void volumeUp(){
//		System.out.println("LgTV -- 소리 증가");	
		speaker.volumeUp();
	}
	@Override
	public void volumeDown(){
//		System.out.println("LgTV -- 소리 감소");
		speaker.volumeDown();
	}
}
