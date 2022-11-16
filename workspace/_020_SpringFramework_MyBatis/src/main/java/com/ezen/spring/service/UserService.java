package com.ezen.spring.service;

import com.ezen.spring.vo.UserVO;

public interface UserService {
	//조회 및 회원가입 기능의 메소트 구현
	UserVO getUser(UserVO userVO);
	//   userDAO의 메소드명과 일치해야함
	void join(UserVO userVO);

}
