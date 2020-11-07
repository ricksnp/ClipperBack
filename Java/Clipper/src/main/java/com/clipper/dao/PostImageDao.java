package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clipper.model.PostImage;
import com.clipper.util.HibernateUtil;

public class PostImageDao implements Dao<PostImage, Integer> {

	@Override
	public List<PostImage> findAll() {
		List<PostImage> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from post_images", PostImage.class).list();
		return list;
	}

	@Override
	public PostImage findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("from PostImage where id = " + i, PostImage.class).list().get(0);
	}

	@Override
	public PostImage update(PostImage t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public PostImage save(PostImage t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public PostImage delete(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("delete from PostImage where id = " + i, PostImage.class).list().get(0);
	}
}
