package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

// interface 기능 정의
// 구현클래스 기능 실행
public interface MemberMapper {
	
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberId);
	public MemberVO selectMember(String MemberId); //단건 조회
	
	//아이디 & 비밀번호
	public MemberVO loginMember(@Param("id") String id, @Param("pw") String pw);
	
}
