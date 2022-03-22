package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.FreeBoardVo;
import net.edupoll.kr.repository.FreeBoardDao;

@Service
public class FreeBoardService {
	@Autowired
	FreeBoardDao freeBoardDao;

	public boolean addNewOne(FreeBoardVo vo) {
		int r = freeBoardDao.inserOne(vo);
		
		return r == 1;
	}
	
	public List<FreeBoardVo> getAll() {
		List<FreeBoardVo> list = freeBoardDao.selectAll();
		
		
		
		return list;
	}

	public FreeBoardVo getOneByNo(int no) {
		FreeBoardVo vo = freeBoardDao.selectOne(no);
		/*
		 * List<FreeBoardVo> list = freeBoardDao.selectListByNo(no);
		 * FreeBoardVo vo = list.get(0);
		 */
		return vo;
	}
}
