package com.example.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.mvc.hibernate.dao.UserDao;
import com.example.spring.mvc.hibernate.entity.Users;
import com.example.spring.mvc.model.UsuariosVO;
import com.example.spring.mvc.utility.EmailMasking;

@Service
public class ServiceUsersImpl implements ServiceUsers {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UsuariosVO getUser(String email) {

		Users users = new Users();
		users.setEmail(email);

		userDao.getUser(users);
		
		UsuariosVO usuariosVO = new UsuariosVO(users.getIdUser(),users.getFirstName(),users.getLastName(),users.getEmail());
		
		return usuariosVO;
	}

	@Override
	public List<UsuariosVO> listUsers() {
		
		List<UsuariosVO> listUsersVO = new ArrayList<UsuariosVO>();
		List<Users> listUsers = userDao.getUsers();
		
		if(listUsers.size() > 0) {
			listUsers.forEach(users -> {
				listUsersVO.add(new UsuariosVO(users.getIdUser(), users.getFirstName(), users.getLastName(), EmailMasking.maskEmail(users.getEmail())));
			});
		}
		return listUsersVO;
		
	}

	@Override
	public boolean deleteUsers(int idUser) {
		
		Users users = userDao.getUser(idUser);
		return userDao.deleteUser(users);
		
	}

}
