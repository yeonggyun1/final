package net.edupoll.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.repository.AccountDao;

@Service
public class SignUpService {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AccountDao accountDao;

	public boolean registerAccount(AccountVo vo) {
		String pass = vo.getUserPass();
		String encodedPass = passwordEncoder.encode(pass);
		vo.setUserPass(encodedPass);
		int r = accountDao.insertOne(vo);
		
		return r ==1 ? true : false;
	}
}
