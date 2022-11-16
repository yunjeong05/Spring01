package com.ezen.spring.polymorphism;

public class SamsungTV implements TV {
	
	int ch = 0;
	// 의존성 관계 생성
	// 소니 스피커에 의존함 
	SonySpeaker  speaker;
	
	// 기본생성자
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	// 멤버변수 초기화 해주는 초기화 메소드 
	// init-method 속성으로 등록하여 항상 전원을 켜면 10채널부터 켜지도록 설정 
	public void initMethod() {
		this.ch = 10; 
	}
	
	// 객체가 삭제되기 전에 실행될 메소드 
	// destroy-method로 등록하여 항상 객체가 삭제되기 전에 채널을 20으로 변경 
	public void destroyMethod() {
		this.ch = 20; 
		System.out.println("객체 삭제 전 채널: " + ch);
	}
	
	@Override
	public void powerOn(){
		System.out.println("SamsungTV -- 전원 켜기");
		System.out.println("SamsungTV -- 현재채널: " + ch);
	}
	@Override
	public void powerOff(){
		System.out.println("SamsungTV -- 전원 끄기");
	}
	@Override
	public void volumeUp(){
//		System.out.println("SamsungTV -- 소리 증가");
		// 의존성 주입
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	@Override
	public void volumeDown(){
//		System.out.println("SamsungTV -- 소리 감소");
		// 의존성 주입
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
