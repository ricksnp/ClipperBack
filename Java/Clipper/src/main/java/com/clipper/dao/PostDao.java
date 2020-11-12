package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	/**
	 * Make sure to list all of the posts in descending order, as you would expect to see 
	 * on a social media platform.
	 */
	@Override
	public List<Post> findAll() {
		List<Post> list = factory.openSession()
				.createNativeQuery("select * from posts order by post_id desc", Post.class).list();
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
		sess.close();
		return t;
	}

	@Override
	public Post save(Post t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		sess.close();
		return t;
	}

	@Override
	public Post delete(Integer i) {
		Post p = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(p);
		tx.commit();
		sess.close();
		return p;
	}
	public void deleteAll() {
		Session sess = factory.openSession();
		sess.createQuery("delete from Post");
		sess.close();
	}
	
	public List<Post> findAllByUserId(Integer i) {
		Session sess = factory.openSession();
		List<Post> list = sess.createQuery("from Post where user_id = " + i, Post.class).list();
		sess.close();
		return list;
	}
	

}