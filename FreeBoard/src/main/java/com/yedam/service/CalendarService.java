package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalendarVO;

public interface CalendarService {
	List<Map<String, Object>> scheduleList();
	boolean addSchedule(CalendarVO cvo);
	boolean removeSchedule(CalendarVO cvo);
	
	//단건조회
	CalendarVO searchSchedule(CalendarVO cvo);
}
