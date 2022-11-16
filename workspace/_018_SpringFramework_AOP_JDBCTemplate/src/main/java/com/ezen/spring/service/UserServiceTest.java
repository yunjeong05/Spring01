package com.ezen.spring.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.spring.vo.UserVO;

public class UserServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 스프링콘테이너 구동
		AbstractApplicationContext applicationContext = new GenericXmlApplicationContext("root-context.xml");
		
		// 2. UserServiceImpl 객체를 Lookup 
		// 인터페이스 그릇에 담는다 UserServiceImpl은 UserService 상속해서 같은 모양이 될 수 있음
		UserService UserService = (UserService)applicationContext.getBean("UserService");
		
		// 3. 회원가입
//		UserVO joinUser = new UserVO();
//		joinUser.setId("ezen");
//		joinUser.setPassword("1234");
//		joinUser.setName("가나다");
//		
//		UserService.join(joinUser); // 함수호출 
		
		// 4. 회원조회 
		// id 세팅하기 위한 UserVO 객체
		UserVO infoUser = new UserVO();
		infoUser.setId("ezen"); // 아이디는 직접 작성해야함 
		//infoUser.setId("admin");
		
		UserVO user = UserService.getUser(infoUser);
		System.out.println(user.toString());
		// 5. 스프링 컨테이너 종료 
		applicationContext.close();

	}

}
