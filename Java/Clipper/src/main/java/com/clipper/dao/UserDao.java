package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clipper.model.User;
import com.clipper.util.HibernateUtil;

public class UserDao implements Dao<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from users", User.class).list();
		return list;
	}

	@Override
	public User findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("from User where id = " + i, User.class).list().get(0);
	}

	@Override
	public User update(User t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public User save(User t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public User delete(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("delete from User where id = " + i, User.class).list().get(0);
	}
}
