package com.example.spring.mvc.service;

import java.util.List;

import com.example.spring.mvc.model.UsuariosVO;

public interface ServiceUsers {
	
	public UsuariosVO getUser(String email);
	public List<UsuariosVO> listUsers();
	public boolean deleteUsers(int idUser);

}
