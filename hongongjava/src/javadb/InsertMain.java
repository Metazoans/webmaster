package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {
	public static void main(String[] args) {
		//데이터 추가
		Connection conn = null;
		
		try {
			//jdbc 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//연결
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결 성공");
			
			//데이터 추가
			String sql = ""
						+ "insert into boards (bno, btitle, bcontent, bwriter, bdate) " //()뒤에 빈칸 붙이기
						+ "values(seq_bno.nextVal, ?, ?, ?, sysdate)";	//bdate는 오라클에서 생성시 sysdate 넣어서 이클립스에서는 생략가능
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"}); //new String[] -> 알고 싶은 내용 선언
			pstmt.setString(1, "눈오는 밤");
			pstmt.setString(2, "눈이 펑펑 내려요...");
			pstmt.setString(3, "snow");
			
			//sql문장 실행
			int rows = pstmt.executeUpdate();	//select 제외하고는 executeUpdate사용
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);	//() 안의 숫자 = 컬럼 번호 1부터 시작
					String title = rs.getString(2);
					System.out.println("저장된 번호 : " + bno + title);
				}
				System.out.println("추가 성공");
				rs.close();
			} else {
				System.out.println("추가 실패");
			}
			
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
