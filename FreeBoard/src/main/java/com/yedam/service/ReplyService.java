package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO reply);
	ReplyVO searchReply(int replyNo);
	
	//댓글 카운트
	int replyCount(int boardNo);
}
