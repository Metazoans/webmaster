package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CalendarMapper;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.CalendarVO;

public class CalendarServiceImpl implements CalendarService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
	
	@Override
	public List<Map<String, Object>> scheduleList() {
		return mapper.scheduleData();
	}
	
	@Override
	public boolean addSchedule(CalendarVO cvo) {
		return mapper.insertSchedule(cvo) == 1;
	}
	
	@Override
	public boolean removeSchedule(CalendarVO cvo) {
		return mapper.deleteSchedule(cvo) == 1;
	}
	
	@Override
	public CalendarVO searchSchedule(CalendarVO cvo) {
		return mapper.selectSchedule(cvo);
	}
	
}
