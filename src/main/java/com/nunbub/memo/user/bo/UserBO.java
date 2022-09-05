package com.nunbub.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nunbub.memo.common.EncryptUtils;
import com.nunbub.memo.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;

	// 회원정보를 user 테이블에 저장
	public int addUser(String loginId, String password, String name, String email) {
		// 비밀번호 암호화		
		String encryptPassword = EncryptUtils.md5(password);
				
		return userDAO.insertUser(loginId, encryptPassword, name, email);
				
	}
	
}
