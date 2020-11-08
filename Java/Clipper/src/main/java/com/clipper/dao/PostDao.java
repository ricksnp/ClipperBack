package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.clipper.model.Post;
import com.clipper.model.User;
import com.clipper.util.HibernateUtil;

@Repository
public class PostDao implements Dao<Post, Integer> {

	private SessionFactory sessionFactory;
	
	public PostDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public PostDao() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Post> findAll() {
		List<Post> list = sessionFactory.openSession()
				.createQuery("from Post", Post.class).list();
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
	        Query q = sess.createQuery("delete from Post where id = :i");
	        
	        Transaction tx = sess.beginTransaction();
	        q.setParameter("i", i);
	        
	        int result = q.executeUpdate();
	        //sess.query("delete from User where user_id = " + i, User.class).list().get(0);
	        tx.commit();
	        
	        return new Post();
	    }
}
