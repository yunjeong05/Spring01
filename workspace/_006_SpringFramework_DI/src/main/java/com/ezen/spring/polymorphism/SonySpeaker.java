package com.ezen.spring.polymorphism;

public class SonySpeaker {
	public SonySpeaker() {
		System.out.println("====> 소니 스피커 객체 생성");
	}

	public void volumeUp() {
		System.out.println("SonySpeaker --- 소리증가");
	}
	
	public void volumeDown() {
		System.out.println("SonySpeaker --- 소리감소");
	}
}
