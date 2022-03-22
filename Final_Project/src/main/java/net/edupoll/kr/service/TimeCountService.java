package net.edupoll.kr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.TimeCountVo;
import net.edupoll.kr.repository.TimeCountDao;

@Service
public class TimeCountService {
	@Autowired
	TimeCountDao timeCountDao;

	public List<Object[]> getCountPerHours() {
		List<TimeCountVo> list = timeCountDao.countPerHours();
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] {"hours","count"});
		for(TimeCountVo vo : list) {
			obj.add(new Object[] {vo.getHour(), vo.getCnt()});
		}
		return obj;
	}

}
