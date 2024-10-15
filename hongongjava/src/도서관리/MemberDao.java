package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 목록(조회 조건), 등록, 수정, 삭제, 단건 조회

public class MemberDao extends DAO {
	// 싱글턴 방식(new로 생성 불가능하게 만듬)
	private static MemberDao instance = new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstance() {
		return instance;
	}
	
	// Connection, startConn, endConn
	// 아이디와 비밀번호 확인해서 true 반환 / false 반환 -> 회원 이름 반환 -> 권한 추가 반환
	Member checkMember(String id, String pw) {
		String sql = "select member_name, responsibility from tbl_member" +
					" where member_id = ? and password = ?";
		startConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));
				
				endConn();
				return member;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return null;
	}
	
	//등록
	public int memberInsert(Member m) {
		String sql = "" +
					"insert into tbl_member( member_id, " +
											"password, " +
											"member_name, " +
											"phone, " +
											"responsibility ) " +
					"values( ?, ?, ?, ?, ? )";
		
		startConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getResponsibility());
			
			pstmt.executeUpdate();
			pstmt.close();
			
			endConn();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return 0;
	}
	
	
	//검색
	public Member memberSelect(String member_id) {
		String sql = "select member_id, " +
							"password, " +
							"member_name, " +
							"phone, " +
							"responsibility, " +
							"creation_date" +
					" from tbl_member" +
					" where member_id=?";
		
		startConn();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setMemberName(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setResponsibility(rs.getString(5));
				m.setCreationDate(rs.getDate(6));
				
				rs.close();
				pstmt.close();
				
				endConn();
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return null;
	}
	
	
	// 목록조회
	List<Member> memberList() {
		String sql = "select member_id" +
					"		,member_name" +
					"		,password" +
					"		,phone" +
					"		,responsibility" +
					"		,creation_date" +
					" from tbl_member";
		List<Member> result = new ArrayList<>();
		startConn();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//조회
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				result.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	} //end of memberList();
	
	//삭제
	public int memberDelete(String member_id) {
		String sql = "delete from tbl_member" +
					" where member_id = ?";
		
		startConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			
			pstmt.executeUpdate();
			pstmt.close();
			
			endConn();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return 0;
	}
	
	
	//변경
	public int memberUpdate(Member m) {
		String sql = "update tbl_member" +
					" set password=?, phone=?" +
					" where member_id=?";
		
		startConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getMemberId());
			
			pstmt.executeUpdate();
			pstmt.close();
			
			endConn();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		endConn();
		return 0;
	}
	
	
}
