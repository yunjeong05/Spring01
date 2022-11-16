package com.ezen.spring.polymorphism;

public class LgTV implements TV {
	// 소니 스피커 의존성 맺기 
	SonySpeaker speaker;
	
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
		// 의존성 주입
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	@Override
	public void volumeDown(){
//		System.out.println("LgTV -- 소리 감소");
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
