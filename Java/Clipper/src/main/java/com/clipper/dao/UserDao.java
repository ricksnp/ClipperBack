package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.User;
import com.clipper.util.HibernateUtil;

@Repository
public class UserDao implements Dao<User, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public UserDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<User> findAll() {
		List<User> list = factory.openSession()
				.createQuery("from User", User.class).list();
		return list;
	}

	@Override
	public User findById(Integer i) {
		Session sess = factory.openSession();
		
		Query<User> q = sess.createQuery("from User where id = " + i, User.class);
		
		return q.list().get(0);
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
		Session sess = factory.openSession();
		Query q = sess.createQuery("delete from User where id = :i");
		
		Transaction tx = sess.beginTransaction();
		q.setParameter("i", i);
		
		int result = q.executeUpdate();
		//sess.query("delete from User where user_id = " + i, User.class).list().get(0);
		tx.commit();
		
		return new User();
	}
}
