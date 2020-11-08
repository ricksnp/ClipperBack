package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.User;

@Repository
public class UserDao implements Dao<User, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public UserDao() {}
	
	@Override
	public List<User> findAll() {
		List<User> list = factory.openSession()
				.createNativeQuery("select * from users", User.class).list();
		return list;
	}

	@Override
	public User findById(Integer i) {
		Session sess = factory.openSession();
		User result = sess.createQuery("from User where id = " + i, User.class).list().get(0);
		sess.close();
		return result;
	}

	@Override
	public User update(User t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public User save(User t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public User delete(Integer i) {
		User u = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(u);
		tx.commit();
		return u;
	}
}
