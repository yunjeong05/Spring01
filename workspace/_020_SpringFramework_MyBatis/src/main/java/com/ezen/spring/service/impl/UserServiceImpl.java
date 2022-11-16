package com.ezen.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.spring.service.UserService;
import com.ezen.spring.vo.UserVO;

//ServiceImpl: 비지니스 로직을 구현하는 클래스 (//서비스 인터페이스를 구현하면서)
//비니니스 로직 처리가 완료된 데이터를 DB에 넣기 위해서 DAO객체를 의존성 주입하여 사용
@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserVO getUser(UserVO userVO) {
		return userDAO.getUser(userVO);
	}
	
	@Override 
	public void join(UserVO userVO) {
		userDAO.join(userVO);
	}

}
