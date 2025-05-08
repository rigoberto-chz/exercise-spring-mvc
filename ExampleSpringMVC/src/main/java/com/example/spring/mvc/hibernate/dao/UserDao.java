package com.example.spring.mvc.hibernate.dao;

import java.util.List;

import com.example.spring.mvc.hibernate.entity.Users;

public interface UserDao {

	public List<Users> getUsers();
	public Users getUser(int idUser);
	public Users getUser(Users users);
	public Users addUser(Users users);
	public boolean deleteUser(Users users);
	
}
