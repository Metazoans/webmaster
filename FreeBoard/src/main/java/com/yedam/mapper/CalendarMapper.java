package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalendarVO;

public interface CalendarMapper {
	public List<Map<String, Object>> scheduleData();
	public int insertSchedule(CalendarVO cvo);
	public int deleteSchedule(CalendarVO cvo);
	
	// 단건 조회(중복체크)
	public CalendarVO selectSchedule(CalendarVO cvo);
}
