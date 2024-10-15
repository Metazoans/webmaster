package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends DAO {
	//필드
	
	//3.insert 메소드 (도서 등록)
	public int bookInsert(Book b) {
		startConn();
		
		String sql = "" +
					" insert into book(title, writer, price, bno)" +
					" values(?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBtitle());
			pstmt.setString(2, b.getBwriter());
			pstmt.setInt(3, b.getBprice());
			pstmt.setString(4, b.getBno());
			
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
	
	//4.select 메소드 (조건 검색 : 첵제목 이용)
	public Book bookSelect(String title) {
		startConn();
		
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
			
			rs.close();
			pstmt.close();
			
			endConn();
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		endConn();
		return null;
	}
	
	//5.select 메소드 (전체 검색)
	public List<Book> allSelect() {
		startConn();
		
		List<Book> list = new ArrayList<>();
		
		String sql = "select *" +
					" from book" +
					" order by bno";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setBtitle(rs.getString(1));
				b.setBwriter(rs.getString(2));
				b.setBprice(rs.getInt(3));
				b.setBno(rs.getString(4));
				
				list.add(b);
			}
			
			rs.close();
			pstmt.close();
			
			endConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		endConn();
		return null;
	}
	
	//6.delete 메소드 (도서 삭제 : 북번호 이용)
	public int bookDelete(String bno) {
		startConn();
		
		String sql = "delete from book" +
					" where bno=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
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
	
	//7.update 메소드 (정보 변경 : 책제목의 가격과 책번호 수정)
	public int bookUpdate(Book b) {
		startConn();
		
		String sql = "update book" +
					" set price=?, bno=?" +
					" where title=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBprice());
			pstmt.setString(2, b.getBno());
			pstmt.setString(3, b.getBtitle());
			
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
