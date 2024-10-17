package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	// 목록 변경, 등록, 삭제, 단건조회
	List<BoardVO> boardList(int page);
	boolean registerBoard(BoardVO board);	//등록
	boolean removeBoard(int boardNo);		//제거
	boolean modifyBoard(BoardVO board);		//수정
	BoardVO searchBoard(int boardNo);		//조회
	
	
}
