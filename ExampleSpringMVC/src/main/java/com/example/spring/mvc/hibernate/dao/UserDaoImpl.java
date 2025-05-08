package com.example.spring.mvc.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.mvc.hibernate.entity.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Users> getUsers() {
		Session session = sessionFactory.openSession();
		HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
		JpaCriteriaQuery<Users> jpaCriteriaQuery = hibernateCriteriaBuilder.createQuery(Users.class);
		JpaRoot<Users> jpaRoot = jpaCriteriaQuery.from(Users.class);
		jpaCriteriaQuery.select(jpaRoot);
		Query<Users> query = session.createQuery(jpaCriteriaQuery);
		List<Users> listUsers = query.getResultList();
		session.close();
		return listUsers;
	}

	@Override
	public Users getUser(int idUser) {
		Session session = sessionFactory.openSession();
		HibernateCriteriaBuilder hibernateCriteriaBuilder = session.getCriteriaBuilder();
		JpaCriteriaQuery<Users> jpaCriteriaQuery = hibernateCriteriaBuilder.createQuery(Users.class);
		JpaRoot<Users> jpaRoot = jpaCriteriaQuery.from(Users.class);
		jpaCriteriaQuery.select(jpaRoot);
		jpaCriteriaQuery.where(hibernateCriteriaBuilder.equal(jpaRoot.get("idUser"), idUser));
		Query<Users> query = session.createQuery(jpaCriteriaQuery);
		Users users = query.getSingleResult();
		session.close();
		return users;
	}

	@Override
	public Users getUser(Users users) {
		Session session = sessionFactory.openSession();

		NativeQuery<Users> query = session.createNativeQuery("SELECT * FROM USERS WHERE EMAIL = :email", Users.class);
		query.setParameter("email", users.getEmail());
		
		List<Users> rows = query.list();
				
		if(rows.size() > 0) {
			return rows.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("deprecation")
	public Users addUser(Users users) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(users);
		session.getTransaction().commit(); 
		session.close(); 
		return users;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteUser(Users users) {		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(users);
		session.getTransaction().commit(); 
		session.close(); 
		return true;
	}
	
}
