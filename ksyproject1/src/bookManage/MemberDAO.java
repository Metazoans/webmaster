package bookManage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//사용자 관리

public class MemberDAO extends DAO {
	//<<공용>>
	//로그인(아이디 비밀번호 체크)
	public Member login(String id, String pw) {
		String sql = "select member_no, " +
							"id, " +
							"password, " +
							"addr, " +
							"tel, " +
							"member_type, " +
							"rental, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from member" +
					" where id=? and password=?";
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boolean rental = (rs.getString(7).equals("true")) ? true : false;
				Member m = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rental,
						rs.getString(8)
						);
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
	//회원가입
	public int join(Member m) {
		int mno = 1;
		String sql = "insert into member(member_no, " +
										"id, " +
										"password, " +
										"addr, " +
										"tel)" +
					" values( ?, ?, ?, ?, ? )";
		List<Member> mlist = allMember();
		for(Member mnum : mlist) {
			if(mno == mnum.getMemberNo()) mno++;
			if(m.getId().equals(mnum.getId())) return 0;
		}
		
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			pstmt.setString(2, m.getId());
			pstmt.setString(3, m.getPassword());
			pstmt.setString(4, m.getAddr());
			pstmt.setString(5, m.getTel());
			
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
	//회원 탈퇴 및 삭제
	int deleteMember(Member m) {
		String sql = "delete from member" +
					" where member_no=?";
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			
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
	//유저 검색
	Member searchMember(String mno) {
		String sql = "select member_no, " +
							"id, " +
							"password, " +
							"addr, " +
							"tel, " +
							"member_type, " +
							"rental, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from member" +
					" where member_no=?";
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boolean rental = rs.getString(7).equals("true") ? true : false;
				Member m = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rental,
						rs.getString(8)
						);
				
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
	
	//<<<user>>>
	//유저 갱신(비밀번호, 주소, 전화번호)
	int updateMember(Member m) {
		String sql = "update member" +
					" set password=?, addr=?, tel=?" +
					" where member_no=?";
		
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getAddr());
			pstmt.setString(3, m.getTel());
			pstmt.setInt(4, m.getMemberNo());
			
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
	
	//<<<admin>>>
	//사용자 목록 출력(member 전체 출력)
	List<Member> allMember() {
		String sql = "select member_no, " +
							"id, " +
							"password, " +
							"addr, " +
							"tel, " +
							"member_type, " +
							"rental, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from member" +
					" order by member_no";
		List<Member> list = new ArrayList<>();
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boolean rental = rs.getString(7).equals("true") ? true : false;
				Member m = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rental,
						rs.getString(8)
						);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return list;
	}
	//유저 권한 변경
	int userAuth(String type, Member m) {
		String sql = "update member" +
					" set ";
		switch(type) {
		case "member_type": sql += "member_type=?"; break;
		case "rental": sql += "rental=?"; break;
		}
		sql += " where member_no=?";
		
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			switch(type) {
			case "member_type":
				String chType = m.getMemberType().equals("user") ? "admin" : "user";
				pstmt.setString(1, chType);
				break;
			case "rental":
				String chRental = m.getRental() ? "false" : "true";
				pstmt.setString(1, chRental);
				break;
			}
			pstmt.setInt(2, m.getMemberNo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			endConn();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
} // end class
