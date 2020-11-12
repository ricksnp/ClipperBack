package com.clipper;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clipper.model.Post;
import com.clipper.model.User;
import com.clipper.repo.LikeDao;
import com.clipper.repo.PostDao;
import com.clipper.repo.UserDao;
import com.clipper.util.Utilities;
//import com.clipper.model.Post;
//import com.clipper.model.User;
public class Driver {

	public static void main(String[] args) throws ClassNotFoundException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");

		UserDao dao = ac.getBean(UserDao.class);
		PostDao pdao = ac.getBean(PostDao.class);
		LikeDao ldao = ac.getBean(LikeDao.class);
		
		
		//dao.save(new User(0, "nathan1", "AAA", "Nathan", "Ricks", "ricks@gmail.com", "lol bio", "pfp link", null, null));
		//User a = new User(0, "user2", "password", "User", "Name", "user@nothing.net", "biography", "profile pic", null, null);
		//User b = new User(0, "user3", "password1", "Userr", "Namee", "userrrr@nothing.net", "biography but more", "profile pic2", null, null);
		//User b = dao.save(a);
		//dao.save(b);
		
		//pdao.save(new Post(0, "Hello World but more", b, null, null));
		
		//System.out.println(dao.delete(1));
		
		//System.out.println(dao.findAll());
		
		//System.out.println(pdao.findById(1));
		//System.out.println(dao.findById(1));
		
		//System.out.println(pdao.findAllByUserId(1));
		//System.out.println("Success!");
		//System.out.println(pdao.findById(1));
		//System.out.println(dao.findById(1));
//		List<Object[]> result = ldao.findByUserAndPost(1, 1);
//		String houseId = null;
//		for(Object[] obj : result){
//			houseId = String.valueOf(obj[0]);
//			System.out.println(houseId);
//			}
		//System.out.println(ldao.findById(Integer.parseInt(1)));
		//Utilities.sendEmail("dawit346@gmail.com", Utilities.hashPassword("Dog"));
		((AbstractApplicationContext) ac).close();
		
		
	}

	
}
