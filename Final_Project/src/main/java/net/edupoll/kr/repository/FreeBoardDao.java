package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.FreeBoardVo;

@Repository
public class FreeBoardDao {

	@Autowired
	SqlSession sqlSession;

	public int inserOne(FreeBoardVo vo) {
		return sqlSession.insert("freeBoard.insertOne", vo);
	}

	public List<FreeBoardVo> selectAll() {
		return sqlSession.selectList("freeBoard.selectAll");
	}

	public FreeBoardVo selectOne(int no) {
		return sqlSession.selectOne("freeBoard.selectOne", no);
	}
	
	public List<FreeBoardVo> selectListByNo(int no) {
		return sqlSession.selectList("freeBoard.selectOne", no);
	}
}
