package net.edupoll.kr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.TimeCountVo;
import net.edupoll.kr.repository.StatisticsDao;

@Service
public class StatisticsService {

	@Autowired
	StatisticsDao statisticsDao;

	public List<Object[]> getMessageCountingPerHours() {
		List<TimeCountVo> li = statisticsDao.countPerHours();
		List<Object[]> ret = new ArrayList<>();
		ret.add(new Object[] { "hours", "count" });

		for (TimeCountVo vo : li) {
			ret.add(new Object[] { vo.getHour(), vo.getCnt() });
		}
		
		return ret;
	}
	
}
