package com.ezen.spring.vo;

import java.sql.Date;

//VO, DTO, Entity의 멤버변수는 모두 private으로 설정
//camelcase형식으로 멤버변수 이름 지정
//getter, setter를 이용해서 멤버변수를 조작 
public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date BoardRegdate;
	private int BoardCnt;
	// 동적쿼리를 위한 멤버변수 선언
	private String searchKeyword;
	
	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public Date getBoardRegdate() {
		return BoardRegdate;
	}
	
	public void setBoardRegdate(Date boardRegdate) {
		BoardRegdate = boardRegdate;
	}
	
	public int getBoardCnt() {
		return BoardCnt;
	}
	
	public void setBoardCnt(int boardCnt) {
		BoardCnt = boardCnt;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", BoardRegdate=" + BoardRegdate + ", BoardCnt=" + BoardCnt + "]";
	}
	
	
}
