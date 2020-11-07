package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clipper.model.Post;
import com.clipper.util.HibernateUtil;

public class PostDao implements Dao<Post, Integer> {

	@Override
	public List<Post> findAll() {
		List<Post> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from posts", Post.class).list();
		return list;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("from Post where id = " + i, Post.class).list().get(0);
	}

	@Override
	public Post update(Post t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public Post save(Post t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Post delete(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("delete from Post where id = " + i, Post.class).list().get(0);
	}

}
