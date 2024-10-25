package com.yedam.control.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;
import com.yedam.vo.CalendarVO;

public class AddEventCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		if(start.length() > 20) start = start.substring(0, 19);
		if(end.length() > 20) end = end.substring(0, 19);
		
		CalendarVO cvo = new CalendarVO();
		cvo.setTitle(title);
		cvo.setStartDate(start);
		cvo.setEndDate(end);
		
		CalendarService svc = new CalendarServiceImpl();
		
		if(svc.searchSchedule(cvo) != null) {
			resp.getWriter().print("{\"retCode\": \"REPET\"}");
			return;
		}
		
		if(svc.addSchedule(cvo))
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		else
			resp.getWriter().print("{\"retCode\": \"FAIL\"}");
		
	}

}
