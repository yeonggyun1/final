package net.edupoll.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.repository.AccountDao;

@Service
public class AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public boolean isValidAccount(String id, String pass) {
		String dbPass = accountDao.selectPassById(id);
		if(dbPass == null)
			return false;
		
		return passwordEncoder.matches(pass, dbPass);
	}
	
	public AccountVo findAccountById(String id) {
		// db에 없으면 null 이 반환되니까..
		return accountDao.selectOneById(id);
	}
	

	public boolean modifyAccount(AccountVo vo) {
		int r = accountDao.updateOne(vo);
		
		return r ==1;
	}
	
}








