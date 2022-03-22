package net.edupoll.kr.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.AccountVo;

@Repository
public class AccountDao {
	@Autowired
	SqlSession sqlSession;
	
	
	public int insertOne(AccountVo vo) {
		return sqlSession.insert("account.insertOne", vo);
	}
	
	public String selectPassById(String id) {
		return sqlSession.selectOne("account.selectPassById", id);
	}
	
	public AccountVo selectOneById(String id) {
		return sqlSession.selectOne("account.selectOneById", id);
	}

	public int updateOne(AccountVo vo) {
		return sqlSession.update("account.updateOne", vo);
	}
}
