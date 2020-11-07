package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clipper.model.PostImage;

@Repository
public class PostImageDao implements Dao<PostImage, Integer> {

	private SessionFactory factory;
	
	@Autowired
	public PostImageDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public PostImageDao() {}
	
	@Override
	public List<PostImage> findAll() {
		List<PostImage> list = factory.openSession()
				.createNativeQuery("select * from post_images", PostImage.class).list();
		return list;
	}

	@Override
	public PostImage findById(Integer i) {
		Session sess = factory.openSession();
		return sess.createQuery("from PostImage where id = " + i, PostImage.class).list().get(0);
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
		Session sess = factory.openSession();
		return sess.createQuery("delete from PostImage where id = " + i, PostImage.class).list().get(0);
	}
}
