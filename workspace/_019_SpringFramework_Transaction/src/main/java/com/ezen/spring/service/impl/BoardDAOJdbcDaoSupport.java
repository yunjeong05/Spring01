package com.ezen.spring.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ezen.spring.vo.BoardVO;

// DAO: DB에 접근하여 쿼리를 수행하는 클래스 
// DAO는 @Repository 어노테이션을 이용하여 객체 자동 생성
// @Controller, @service,@Repository는 @Component을 상속 
// 각각 Controller, ServiceImpl, DAO 클래스에 특화된 기능들을 Component보다 더 제공
//특화되게 사용하기 위해서 각각 구분해서 사용하는 것이 좋다. 
//@Repository 
//JDBCDaoSupport를 상속받아서 JDBC template로 DB연동하는 코드로 변경
public class BoardDAOJdbcDaoSupport extends JdbcDaoSupport {
	//JDBC 관련 변수 - JDBC에서 템플릿연결로 연결 만들 필요없어서 삭제  
	
	//SQL 쿼리
	private final String BOARD_INSERT = "INSERT INTO BOARD VALUES((select IFNULL(MAX(A.BOARD_NO),0)+1 FROM BOARD A),?,?,?,now(),0)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? , BOARD_WRITER = ? where BOARD_NO = ?";
	private final String BOARD_DELETE = "DELETE FROM BOARD WHERE BOARD_NO = ?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE BOARD_NO = ? ";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY BOARD_NO DESC"; 

	// JDBC Template 의존성 주입
	// 오토와이어가 매개변수도 같은 모양의 객체를 찾아 자동으로 의존성 주입,, 템플릿이 데이터소스를 가지고...
	@Autowired 
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		
	}
	// CRUD 기능구현 
	// 글 등록
	public void insertBoard(BoardVO boardVO) {
		System.out.println("JDBC로 insertBoard 기능구현");
		
		getJdbcTemplate().update(BOARD_INSERT, boardVO.getBoardTitle(), boardVO.getBoardContent(), boardVO.getBoardWriter());
	}
	// 글 수정
	public void updateBoard(BoardVO boardVO) {
		System.out.println("JDBC updateBoard 기능구현");
		
		getJdbcTemplate().update(BOARD_UPDATE, boardVO.getBoardTitle(), boardVO.getBoardContent(), boardVO.getBoardWriter(),
				boardVO.getBoardNo());
	}
	
	// 글 삭제 
	public void deleteBoard(BoardVO boardVO) {
		System.out.println("JDBC delete 기능구현");
		
		getJdbcTemplate().update(BOARD_DELETE,boardVO.getBoardNo());
	}
	
	// 글 상세조회 
	public BoardVO getBoard(BoardVO boardVO) {
		System.out.println("JDBC getBoard 기능구현");
		// 인자가 하나인 오프젝트 배열 필요 (두번째)
		Object[] args = {boardVO.getBoardNo()};
		
								  // 단건 						// 받아줄 객체 필요
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper()); 
	}
	// 글 목록조회 
	public List<BoardVO> getBoardList(){
		System.out.println("JDBC getBoardList 기능구현");
													// 받아줄 인자
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
	
}