package com.example.spring.mvc.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.mvc.hibernate.dao.UserDao;
import com.example.spring.mvc.hibernate.entity.Users;
import com.example.spring.mvc.hibernate.entity.Access;
import com.example.spring.mvc.model.LoginVO;
import com.example.spring.mvc.utility.CipherUtil;

@Service
public class ServiceLoginImpl implements ServiceLogin {

	@Autowired
	private UserDao userDao;
	
	@Override
	public LoginVO login(LoginVO loginVO) {
		
		Users users = new Users();
		users.setEmail(loginVO.getEmail().toUpperCase());
		
		users = userDao.getUser(users);
		
		if(users != null) {
			Access access = (Access) users.getAccesses().stream().findFirst().get();
			CipherUtil cipherUtil = new CipherUtil();
			
			try {
				if(cipherUtil.decrypt(access.getPassword(), "secret").equals(loginVO.getPassword())) {
					loginVO.setIdUser(users.getIdUser());
					loginVO.setFirstName(users.getFirstName());
					loginVO.setLastName(users.getLastName());
					loginVO.setMessage("logon");
				} else {
					loginVO.setMessage("error");
				}
			} catch (InvalidKeyException e) {
				loginVO.setMessage("error");
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				loginVO.setMessage("error");
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				loginVO.setMessage("error");
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				loginVO.setMessage("error");
				e.printStackTrace();
			} catch (BadPaddingException e) {
				loginVO.setMessage("error");
				e.printStackTrace();
			}
			
		} else {
			loginVO.setMessage("register");
		}
		
		return loginVO;
	}

}
