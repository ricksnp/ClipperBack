package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.Post;

@Repository
public class PostDao implements Dao<Post, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public PostDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public PostDao() {}
	
	@Override
	public List<Post> findAll() {
		List<Post> list = sessionFactory.openSession()
				.createQuery("from Post", Post.class).list();
		return list;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = factory.openSession();
		Post result = sess.createQuery("from Post where id = " + i, Post.class).list().get(0);
		sess.close();
		return result;
	}

	@Override
	public Post update(Post t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public Post save(Post t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Post delete(Integer i) {
		Post p = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(p);
		tx.commit();
		return p;
	}

}