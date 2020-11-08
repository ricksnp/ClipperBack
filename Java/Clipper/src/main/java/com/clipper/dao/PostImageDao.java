package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.Post;
import com.clipper.model.PostImage;
import com.clipper.model.User;
import com.clipper.util.HibernateUtil;

@Repository
public class PostImageDao implements Dao<PostImage, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public PostImageDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public PostImageDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public List<PostImage> findAll() {
		List<PostImage> list = factory.openSession()
				.createQuery("from PostImage", PostImage.class).list();
		return list;
	}

	@Override
	public PostImage findById(Integer i) {
		Session sess = factory.openSession();
		PostImage result = sess.createQuery("from PostImage where id = " + i, PostImage.class).list().get(0);
		sess.close();
		return result;
	}

	@Override
	public PostImage update(PostImage t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public PostImage save(PostImage t) {
		SessionFactory sesfact = factory;
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public PostImage delete(Integer i) {
		PostImage p = findById(i);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(p);
		tx.commit();
		return p;
	}
	public void deleteAll() {
		Session sess = factory.openSession();
		sess.createQuery("delete from PostImage");
	}
	
}