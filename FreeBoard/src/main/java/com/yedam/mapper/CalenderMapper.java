package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalenderVO;

public interface CalenderMapper {
	public List<Map<String, Object>> scheduleData();
	public int insertSchedule(CalenderVO cvo);
	public int deleteSchedule(CalenderVO cvo);
	
	// 단건 조회(중복체크)
	public CalenderVO selectSchedule(CalenderVO cvo);
}
