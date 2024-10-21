package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.getRequestDispatcher("board/deleteForm.tiles").forward(req, resp);

			
		} else if(req.getMethod().equals("POST")) {
			if(svc.removeBoard(Integer.parseInt(bno))) {
				//if(svc.boardList(Integer.parseInt(page)) == null) int pg = Integer.parseInt(page) - 1;
				String s = "searchCondition=" + sc;
				s += "&keyword=" + kw;
				s += "&page=" + page;
				resp.sendRedirect("boardList.do?" + s);
			} else {
				BoardVO board = svc.searchBoard(Integer.parseInt(bno));

				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "삭제 실패");
				req.getRequestDispatcher("board/deleteForm.tiles").forward(req, resp);
			}
			
		}
	}

}
