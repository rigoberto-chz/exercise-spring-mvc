package com.example.spring.mvc.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.mvc.hibernate.dao.AccessDao;
import com.example.spring.mvc.hibernate.dao.UserDao;
import com.example.spring.mvc.hibernate.entity.Users;
import com.example.spring.mvc.hibernate.entity.Access;
import com.example.spring.mvc.model.RegisterVO;
import com.example.spring.mvc.utility.CipherUtil;

@Service
public class ServiceRegisterImpl implements ServiceRegister {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AccessDao accessDao;

	@Override
	public RegisterVO register(RegisterVO registerVO) {
		
		Users users = new Users();	
		users.setEmail(registerVO.getEmail().toUpperCase());
		users.setFirstName(registerVO.getFirstName().toUpperCase());
		users.setLastName(registerVO.getLastName().toUpperCase());
		userDao.addUser(users);
		
		CipherUtil cipherUtil = new CipherUtil();
		
		Access access = new Access();		
		access.setUsers(users);
		try {
			access.setPassword(cipherUtil.encrypt(registerVO.getPassword(), "secret"));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		accessDao.addAccess(access);
		
		return registerVO;
	}
	
}
