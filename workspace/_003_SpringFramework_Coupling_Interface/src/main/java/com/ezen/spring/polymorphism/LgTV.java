package com.ezen.spring.polymorphism;

public class LgTV implements TV {
	
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
		System.out.println("LgTV -- 소리 증가");
	}
	@Override
	public void volumeDown(){
		System.out.println("LgTV -- 소리 감소");
	}
}
