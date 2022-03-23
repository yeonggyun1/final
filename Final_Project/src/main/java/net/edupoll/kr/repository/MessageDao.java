package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.MessageVo;


@Repository
public class MessageDao { 

	@Autowired
	SqlSession session;
	
	public int insertOne(MessageVo vo) {
		return session.insert("message.insertOne", vo);
	}
	
	public List<MessageVo> selectSomeByWriter(String id) {
		return session.selectList("message.selectSomeByWriter", id);
	}
	
	public List<MessageVo> selectSomeByReader(String id) {
		return session.selectList("message.selectSomeByReader", id);
	}
	
	public MessageVo selectOneByNo(int no) {
		return session.selectOne("message.selectOneByNo", no);
	}
              	
	public int countReadDateIsNull(String id) {
		
		return session.selectOne("message.countReadDateIsNull", id);
	}
	
	public int updateReadDateByNo(int no) {
		return session.update("message.updateReadDateByNo", no);
	}
	
	
	public int deleteSomeByNo(String[] no) {
		return session.delete("message.deleteSomeByNo", no);
	}
	
}
