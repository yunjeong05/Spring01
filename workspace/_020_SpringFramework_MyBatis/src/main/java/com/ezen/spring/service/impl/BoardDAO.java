package com.ezen.spring.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.spring.vo.BoardVO;

// DAO: DB에 접근하여 쿼리를 수행하는 클래스 
// DAO는 @Repository 어노테이션을 이용하여 객체 자동 생성
// @Controller, @service,@Repository는 @Component을 상속 
// 각각 Controller, ServiceImpl, DAO 클래스에 특화된 기능들을 Component보다 더 제공
//특화되게 사용하기 위해서 각각 구분해서 사용하는 것이 좋다. 
@Repository 
public class BoardDAO {
	// SqlSessionTemplate을 받아오기 
	@Autowired
	SqlSessionTemplate mybatis;
	
	//쿼리문은 분리하기 때문에 필요없어서 삭제함 -> board-mapper.xml에 쿼리문 작성
	
	// CRUD 기능구현 
	// 글 등록
	public void insertBoard(BoardVO boardVO) {
		System.out.println("JDBC로 insertBoard 기능구현");
											// boardVO에서 title ,content, writer 꺼내와야함
		mybatis.insert("BoardDAO.insertBoard", boardVO);
	}											
	// 글 수정
	public void updateBoard(BoardVO boardVO) {
		System.out.println("JDBC updateBoard 기능구현");
					 							//.getBoardNo()
		mybatis.update("BoardDAO.updateBoard", boardVO);
	}
	
	// 글 삭제 
	public void deleteBoard(BoardVO boardVO) {
		System.out.println("JDBC delete 기능구현");
		
		mybatis.delete("BoardDAO.deleteBoard",boardVO.getBoardNo());
	}
	
	// 글 상세조회 
	public BoardVO getBoard(BoardVO boardVO) {
		System.out.println("JDBC getBoard 기능구현");	
					 	// 단건
		return mybatis.selectOne("BoardDAO.getBoard", boardVO); 
	}
	// 글 목록조회 
	public List<BoardVO> getBoardList(BoardVO boardVO){
		System.out.println("JDBC getBoardList 기능구현");
											// boardVO 매개변수 받지 않아서 넣을 필요 없었지만 동적 쿼리에는 boardVO 넣음
		return mybatis.selectList("BoardDAO.getBoardList", boardVO);
	}
	
}
