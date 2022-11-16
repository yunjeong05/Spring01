package com.ezen.spring.service;

import java.util.List;

import com.ezen.spring.vo.BoardVO;

public interface BoardService {
	// CRUD(Create Read Update Delete)기능의 메소드 구현
	// 글 등록         //매핑할 매개변수
	void insertBoard(BoardVO boardVO); 
	
	// 글 수정
	void updateBoard(BoardVO boardVO);
	// 글 삭제 
	void deleteBoard(BoardVO boardVO); 
	
	// 글 상세 조회 - 몇번글을 상세조회 할 것 인지 
	BoardVO getBoard(BoardVO boardVO);
	
	// 글 목록 조회 - 전체글을 가져오는데 필요한 메소드 이용할 예정 
	// 리스트로 BoardVO를 담아서 출력..
	List<BoardVO> getBoardList();
	
}
