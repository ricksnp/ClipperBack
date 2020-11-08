package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.clipper.model.Like;
import com.clipper.model.Post;
import com.clipper.model.User;
import com.clipper.util.HibernateUtil;
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
	public LikeDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<Like> findAll() {
		List<Like> list = factory.openSession()
				.createQuery("from Like", Like.class).list();
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
		Like p = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(p);
		tx.commit();
		return p;
	    }
	public void deleteAll() {
		Session sess = factory.openSession();
		sess.createQuery("delete from Like");
	}
	
}