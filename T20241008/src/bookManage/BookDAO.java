package bookManage;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//도서 관리

public class BookDAO extends DAO {
	//<<<공용>>>
	//도서 목록(전체 목록)
	List<Book> allBook() {
		String sql = "select book_no, " +
							"title, " +
							"writer, " +
							"book_type, " +
							"intro, " +
							"rental_user, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from books" +
					" order by book_no";
		List<Book> list = new ArrayList<>();
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						);
				list.add(b);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return list;
	}
	//도서 검색
	Book searchBook(String type, String srch) { //검색 조건 문자열로 받아서 where에 추가
		String sql = "select book_no, " +
							"title, " +
							"writer, " +
							"book_type, " +
							"intro, " +
							"rental_user, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from books" +
					" where " + type + "=?";
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, srch);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Book b = new Book(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						);
				
				pstmt.close();
				rs.close();
				endConn();
				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return null;
	}
	
	//도서 검색 리스트
	List<Book> searchList(String type, String srch) { //검색 조건 문자열로 받아서 where에 추가
		String sql = "select book_no, " +
							"title, " +
							"writer, " +
							"book_type, " +
							"intro, " +
							"rental_user, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from books" +
					" where " + type + " like '%'||?||'%'" +
					" order by book_no";
		List<Book> blist = new ArrayList<>();
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, srch);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						);
				blist.add(b);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return blist;
	}
	
	
	//<<<사용자>>>
	//도서 대출
	int rentalBook(int bno, int mno) {
		if(searchBook("book_no", "" + bno).getRentalDate() != null) return 0;
		
		String sql = "update books" +
					" set rental_user=?, rental_date=(sysdate+7)" +
					" where book_no=?";
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			pstmt.setInt(2, bno);
			
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
	//도서 반납
	int returnBook(Book b, Member m) {
		int result = 0; //return값 0이면 정상 반납, 1이면 연체 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar sd = Calendar.getInstance();
		int sysdate = Integer.parseInt(df.format(sd.getTime()));
		boolean late = (Integer.parseInt(b.getRentalDate()) < sysdate) ? true : false; //연체면 true
		
		String msql = "", bsql = "";

		startConn();
		if(late) {
			result = 1;
			msql += "update member " +
					"set rental=false, rental_date=sysdate+? " +
					"where member_no=?";
			
			int d = sysdate - Integer.parseInt(b.getRentalDate());
			try {
				pstmt = conn.prepareStatement(msql);
				pstmt.setInt(1, d);
				pstmt.setInt(2, m.getMemberNo());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		bsql += "update books " +
				"set rental_user=null, rental_date=null " +
				"where book_no=?";
		try {
			pstmt = conn.prepareStatement(bsql);
			pstmt.setInt(1, b.getBookNo());
			
			pstmt.executeUpdate();
			pstmt.close();
			endConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//대출 연장
	int rentalExtend(int bno) {
		String sql = "update books " +
					" set rental_date=rental_date+7" +
					" where book_no=?";
		
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
	//대출 목록
	List<Book> rentalList(Member m) {
		String sql = "select book_no, " +
							"title, " +
							"writer, " +
							"book_type, " +
							"intro, " +
							"rental_user, " +
							"to_char(rental_date, 'yyyymmdd')" +
					" from books" +
					" where rental_user=?" +
					" order by book_no";
		List<Book> list = new ArrayList<>();
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMemberNo());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						);
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endConn();
		return list;
	}
	
	//<<<관리자>>>
	//도서 추가
	int insertBook(Book b) {
		String sql = "insert into books( book_no, " +
										"title, " +
										"writer, " +
										"book_type, " +
										"intro)" +
					" values( ?, ?, ?, ?, ? )";
		
		List<Book> blist = allBook();
		int bno = 1;
		for(Book bnum : blist) {
			if(bno == bnum.getBookNo()) bno++;
		}
		
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getBookType());
			pstmt.setString(5, b.getIntro());
			
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
	//도서 갱신
	int updateBook(String bno, Book b) {
		String sql = "update books" +
					" set title=?, writer=?, book_type=?, intro=?" +
					" where book_no=?";
		
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getBookType());
			pstmt.setString(4, b.getIntro());
			pstmt.setString(5, bno);
			
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
	//도서 삭제
	int deleteBook(String bno) {
		String sql = "delete from books" +
					" where book_no=?";
		startConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
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
} // end class
