package com.clipper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.clipper.model.Like;
import com.clipper.model.User;
import com.clipper.util.HibernateUtil;

@Repository
public class LikeDao implements Dao<Like, Integer> {

	private SessionFactory sessionFactory;
	
	public LikeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public LikeDao() {
		this.sessionFactory = HibernateUtil.getSessionFactory();

	}

	@Override
	public List<Like> findAll() {
		List<Like> list = sessionFactory.openSession()
				.createNativeQuery("select * from dev.likes", Like.class).list();
		return list;
	}

	@Override
	public Like findById(Integer i) {
		Session sess = sessionFactory.openSession();
		return sess.createQuery("from dev.likes where id = " + i, Like.class).list().get(0);
	}

	@Override
	public Like update(Like t) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(t);
		tx.commit();
		return t;
	}

	@Override
	public Like save(Like t) {
		
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	
	@Override
	 public Like delete(Integer i) {
	        Session sess = sessionFactory.openSession();
	        Query q = sess.createQuery("delete from likes where id = :i");
	        
	        Transaction tx = sess.beginTransaction();
	        q.setParameter("i", i);
	        
	        int result = q.executeUpdate();
	        //sess.query("delete from User where user_id = " + i, User.class).list().get(0);
	        tx.commit();
	        
	        return new Like();
	    }
	
}
