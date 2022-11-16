package com.ezen.spring.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ezen.spring.common.JDBCUtil;
import com.ezen.spring.vo.UserVO;

@Repository
public class UserDAO {
	private Connection conn = null; 
	private PreparedStatement  stmt = null;
	private ResultSet rs = null;
	
	private final String GET_USER = "SELECT * FROM USER WHERE ID = ?";
	private final String USER_JOIN = "INSERT INTO USER VALUES(?,?,?,'USER') ";
	
	// 회원가입 (정보삽입)
	public void join(UserVO userVO) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_JOIN);
			
			stmt.setString(1, userVO.getId());
			stmt.setString(2, userVO.getPassword());
			stmt.setString(3, userVO.getName());
			
			stmt.executeUpdate();
	 	} catch (Exception e) {
	 		System.out.println(e.getMessage());
	  	} finally {
	  		JDBCUtil.close(stmt, conn);
	  	}
		
	}
	
	//회원 조회 
	public UserVO getUser(UserVO userVO) {
		UserVO user = new UserVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_USER);
			stmt.setString(1, userVO.getId());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user; 
		
	}

}
