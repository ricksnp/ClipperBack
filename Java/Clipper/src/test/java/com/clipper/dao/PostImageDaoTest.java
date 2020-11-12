package com.clipper.dao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clipper.model.Post;
import com.clipper.model.PostImage;
import com.clipper.model.User;
import com.clipper.repo.PostDao;
import com.clipper.repo.PostImageDao;
import com.clipper.repo.UserDao;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostImageDaoTest {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("config2.xml");
	
	private static User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private static Post post; 
	private static PostImage postImage ;
	private static UserDao ud = ac.getBean(UserDao.class);
	private static PostDao pd = ac.getBean(PostDao.class);
	private static PostImageDao pid = ac.getBean(PostImageDao.class);
	@BeforeClass
	public static void prepare() throws Exception {
		
		ud.save(user);
		
		User u = ud.findAll().get(0);
		post = new Post(0, "James is great",u, null, null);
		pd.save(post);
		Post p = pd.findAll().get(0);
		postImage = new PostImage(0,"img.link", p);
	}
	@Test
	public void A_CreatePostImage() {
		assertEquals(postImage, pid.save(postImage));
	}
	@Test
	public void B_FindAllPostImage() {
		assertEquals(1, pid.findAll().get(0).getId());
	}
	@Test
	public void C_FindPostImageById() {
		assertEquals(1,pid.findById(1).getId());
	}
	@Test
	public void D_UpdatePostImage() {
		assertEquals(postImage, pid.update(postImage));
	}
	@Test
	public void E_DeletePostImage() {
		assertEquals(pid.findById(1).getId(),pid.delete(1).getId());
	}
	@AfterClass
	public static void Z_DeleteAll() {
		pid.deleteAll();
		pd.deleteAll();
		ud.deleteAll();
	}

}
