package com.ezen.spring.polymorphism;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("===> 애플스피커 객체 생성");	
	}
	
	public void volumeUp() {
		System.out.println("애플 스피커 -- 소리증가");
	}
	
	public void volumeDown() {
		System.out.println("애플 스피커 -- 소리감소");
	}
}
