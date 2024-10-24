package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CalenderMapper;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.CalenderVO;

public class CalenderServiceImpl implements CalenderService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CalenderMapper mapper = sqlSession.getMapper(CalenderMapper.class);
	
	@Override
	public List<Map<String, Object>> scheduleList() {
		return mapper.scheduleData();
	}
	
	@Override
	public boolean addSchedule(CalenderVO cvo) {
		return mapper.insertSchedule(cvo) == 1;
	}
	
	@Override
	public boolean removeSchedule(CalenderVO cvo) {
		return mapper.deleteSchedule(cvo) == 1;
	}
	
	@Override
	public CalenderVO searchSchedule(CalenderVO cvo) {
		return mapper.selectSchedule(cvo);
	}
	
}
