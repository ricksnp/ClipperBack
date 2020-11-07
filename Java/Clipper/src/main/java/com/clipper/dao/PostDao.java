package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clipper.model.Post;
import com.clipper.util.HibernateUtil;

public class PostDao implements Dao<Post, Integer> {

	private SessionFactory sessionFactory;
	
	public PostDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Post> findAll() {
		List<Post> list = sessionFactory.openSession()
				.createNativeQuery("select * from posts", Post.class).list();
		return list;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = sessionFactory.openSession();
		return sess.createQuery("from Post where id = " + i, Post.class).list().get(0);
	}

	@Override
	public Post update(Post t) {
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public Post save(Post t) {
	
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Post delete(Integer i) {
		Session sess = sessionFactory.openSession();
		return sess.createQuery("delete from Post where id = " + i, Post.class).list().get(0);
	}

}
