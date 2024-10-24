package com.yedam.control.calender;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.CalenderService;
import com.yedam.service.CalenderServiceImpl;
import com.yedam.vo.CalenderVO;

public class AddEventCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		if(start.length() > 20) start = start.substring(0, 19);
		if(end.length() > 20) end = end.substring(0, 19);
		
		CalenderVO cvo = new CalenderVO();
		cvo.setTitle(title);
		cvo.setStartDate(start);
		cvo.setEndDate(end);
		
		CalenderService svc = new CalenderServiceImpl();
		
		if(svc.searchSchedule(cvo) != null) {
			resp.getWriter().print("{\"retCode\": \"\"}");
		}
		
		if(svc.addSchedule(cvo))
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		else
			resp.getWriter().print("{\"retCode\": \"FAIL\"}");
		
	}

}
