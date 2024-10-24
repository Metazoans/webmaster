package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	// 목록 변경, 등록, 삭제, 단건조회
	List<BoardVO> boardList(SearchDTO search);
	boolean registerBoard(BoardVO board);	//등록
	boolean removeBoard(int boardNo);		//제거
	boolean modifyBoard(BoardVO board);		//수정
	BoardVO searchBoard(int boardNo);		//조회
	//페이징 카운트
	int getTotalCount(SearchDTO search);
	
	// 사용자별 게시글
	List<Map<String, Object>> countByWriter();
	
}
