package bookManageSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {
	//필드
	Connection conn = null;
	
	
	
	//메소드
	//1.연결 설정 메소드(void)
	public void startConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//2.연결 끊기 메소드(void)
	public void endConn() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("연결 종료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//3.insert 메소드 (도서 등록)
	public void bookInsert(String title, String writer, int price, String bno) {
		String sql = "" +
					" insert into book(title, writer, price, bno)" +
					" values(?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setInt(3, price);
			pstmt.setString(4, bno);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("도서 등록 성공");
		} catch (SQLException e) {
			System.out.println("도서 등록 실패");
			e.printStackTrace();
		}
	}
	
	//4.select 메소드 (조건 검색 : 첵제목 이용)
	public void bookSelect(String title) {
		String sql = "select *" +
					" from book" +
					" where title=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			Book b = new Book();
			b.setBtitle(rs.getString(1));
			b.setBwriter(rs.getString(2));
			b.setBprice(rs.getInt(3));
			b.setBno(rs.getString(4));
			
			System.out.println(b);
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("검색 실패");
			e.printStackTrace();
		}
	}
	
	//5.select 메소드 (전체 검색)
	public void allSelect() {
		String sql = "select *" +
					" from book" +
					" order by title";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setBtitle(rs.getString(1));
				b.setBwriter(rs.getString(2));
				b.setBprice(rs.getInt(3));
				b.setBno(rs.getString(4));
				
				System.out.println(b);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("검색 실패");
			e.printStackTrace();
		}
	}
	
	//6.delete 메소드 (도서 삭제 : 북번호 이용)
	public void bookDelete(String bno) {
		String sql = "delete from book" +
					" where bno=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("도서 삭제 성공");
		} catch (SQLException e) {
			System.out.println("도서 삭제 실패");
			e.printStackTrace();
		}
	}
	
	//7.update 메소드 (정보 변경 : 책제목의 가격과 책번호 수정)
	public void bookUpdate(String title, int price, String bno) {
		String sql = "update book" +
					" set price=?, bno=?" +
					" where title=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, bno);
			pstmt.setString(3, title);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("도서 정보 갱신 성공");
		} catch (SQLException e) {
			System.out.println("도서 정보 갱신 실패");
			e.printStackTrace();
		}
	}
	
}
