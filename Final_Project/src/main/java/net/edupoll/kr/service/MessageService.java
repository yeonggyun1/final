package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.MessageVo;
import net.edupoll.kr.repository.MessageDao;


@Service
public class MessageService {
	@Autowired
	MessageDao messageDao;

	public boolean sendNewMessage(String sender, MessageVo message) {
		message.setWriter(sender);
		int r = 0;
		for(String recipient : message.getRecipients()) {
			message.setRecipient(recipient);
			r += messageDao.insertOne(message);
		}
		return r == message.getRecipients().length;
	}
	
	

	public List<MessageVo> getSentMessages(String user) {
		List<MessageVo> list = messageDao.selectSomeByWriter(user);
		return list;
	}

	public List<MessageVo> getReceivedMessages(String user) {
		List<MessageVo> list = messageDao.selectSomeByReader(user);
		return list;
	}

	public MessageVo getMessage(String user, int no) {
		MessageVo vo = messageDao.selectOneByNo(no);
		if (user.equals(vo.getRecipient())) {
			messageDao.updateReadDateByNo(no);
		}
		return vo;
	}

	public int getUncheckedMessagesCount(String user) {
		return messageDao.countReadDateIsNull(user);
	}

}
