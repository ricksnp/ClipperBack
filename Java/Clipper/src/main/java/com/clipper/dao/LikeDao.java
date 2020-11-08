package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.Like;

@Repository
public class LikeDao implements Dao<Like, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public LikeDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public LikeDao() {}
	
	@Override
	public List<Like> findAll() {
		List<Like> list = factory.openSession()
				.createNativeQuery("select * from likes", Like.class).list();
		return list;
	}

	@Override
	public Like findById(Integer i) {
		Session sess = factory.openSession();
		Like result = sess.createQuery("from Like where id = " + i, Like.class).list().get(0);
		sess.close();
		return result;
	}

	@Override
	public Like update(Like t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public Like save(Like t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Like delete(Integer i) {
		Like l = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(l);
		tx.commit();
		return l;
	}
	
}
