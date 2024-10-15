package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMain {
	public static void main(String[] args) {
		//연결하기
		Connection conn = null;
		
		//jdbc 드라이버 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			//db연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",	//url
					"java",	//계정
					"1234"	//비밀번호
					);
			System.out.println("연결 성공");
			
			//데이터 수정
			String sql = ""
						+ "update boards "
						+ "set btitle=?, bcontent=? "
						+ "where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"btitle", "bcontent", "bno"});
			pstmt.setString(1, "55");
			pstmt.setString(2, "555");
			pstmt.setInt(3, 5);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : " + rows);
			
//			if(rows == 1) {
//				ResultSet rs = pstmt.getGeneratedKeys();
//				if(rs.next()) {
//					String title = rs.getString(1);
//					String content = rs.getString(2);
//					int bno = rs.getInt(3);
//					System.out.printf("%d : %s : %s\n", bno, title, content);
//				}
//				System.out.println("추가 성공");
//				rs.close();
//			} else {
//				System.out.println("추가 실패");
//			}
			
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}
}
