package com.example.spring.mvc.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.mvc.hibernate.entity.Access;

@Repository
public class AccessDaoImpl implements AccessDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	public Access addAccess(Access access) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(access);
		session.getTransaction().commit(); 
		session.close(); 
		return access;
	}

}
