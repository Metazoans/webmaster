package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	Map<String, Control> map;
	
	public FrontController() {
		//System.out.println("객체생성");
		map = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
		//System.out.println("init호출");
		map.put("/memberList.do", new MemberListControl());
		map.put("/memberAdd.do", new MemberAddControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("service호출");
		// 요청페이지?
		// http://localhost/FreeBoard/add.do (전체 : url)
		String uri = req.getRequestURI(); // /FreeBoard/add.do (부분 : uri)
		String context = req.getContextPath(); // /FreeBoard
		String page = uri.substring(context.length()); // /add.do
		
		Control control = map.get(page);
		control.exec(req, resp);
		
	}
	
}
