package chap13;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	List<Board> list = new ArrayList<>();

	public List<Board> getBoardList() {
		int lLength = 3;
		for(int i = 0; i < lLength; i++) {
			list.add(new Board("제목" + (i + 1), "내용" + (i + 1), "저자" + (i + 1)));
		}
		
		return list;
	}
}
