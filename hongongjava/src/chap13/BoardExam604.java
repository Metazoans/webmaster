package chap13;

import java.util.List;

public class BoardExam604 {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board b : list) {
			System.out.printf("%s-%s-%s\n", b.getSubject(), b.getContent(), b.getWriter());
		}
	}

}
