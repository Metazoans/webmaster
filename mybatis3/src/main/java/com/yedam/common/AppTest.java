package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class AppTest {
	public static void main(String[] args) {
		//jdbc기준
		//MemberDAO dao = new MemberDAO();
		//List<Member> result = dao.memberList();
		
		//mybatis기준
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		//등록
		Member mbr = new Member();
		mbr.setMemberId("test99");
		//mbr.setMemberName("연습99");
		//mbr.setPhone("010-8888-8888");
		mbr.setPassword("9999");
		
		//if(dao.insertMember(mbr) == 1) sqlSession.commit();
		
		//if(dao.updateMember(mbr) == 1) sqlSession.commit();
		
		if(dao.deleteMember(mbr.getMemberId()) == 1) sqlSession.commit();
		
		List<Member> result = dao.members();
		for(Member member : result) System.out.println(member.toString());
		
		
		
	} //end main
	
} //end class
