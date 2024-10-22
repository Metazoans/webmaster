package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		ReplyVO reply = new ReplyVO();
		reply.setReply("test1asdf");
		reply.setReplyer("asdf");
		reply.setBoardNo(160);
		
//		mapper.deleteReply(7);
		ReplyService svc = new ReplyServiceImpl();
		
		svc.addReply(reply);
		
		List<ReplyVO> list = svc.replyList(160);
		for(ReplyVO rvo : list) System.out.println(rvo.toString());
		
		
		
	}
}
