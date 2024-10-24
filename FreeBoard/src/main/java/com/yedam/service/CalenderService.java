package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalenderVO;

public interface CalenderService {
	List<Map<String, Object>> scheduleList();
	boolean addSchedule(CalenderVO cvo);
	boolean removeSchedule(CalenderVO cvo);
	
	//단건조회
	CalenderVO searchSchedule(CalenderVO cvo);
}
