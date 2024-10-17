package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class deleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/deleteForm.jsp").forward(req, resp);

			
		} else if(req.getMethod().equals("POST")) {
			if(svc.removeBoard(Integer.parseInt(bno))) {
				resp.sendRedirect("boardList.do");
			} else {
				BoardVO board = svc.searchBoard(Integer.parseInt(bno));

				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "삭제 실패");
				req.getRequestDispatcher("WEB-INF/jsp/deleteForm.jsp").forward(req, resp);
			}
			
		}
	}

}
