package com.ezen.spring.polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {// Speaker 상속 받았기 때문에 소니스피커도 스피커 모양으로 본다.
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
