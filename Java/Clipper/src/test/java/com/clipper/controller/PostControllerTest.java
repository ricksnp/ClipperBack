package com.clipper.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clipper.controller.LikeController;
import com.clipper.dao.LikeDao;
import com.clipper.dao.PostDao;
import com.clipper.dao.UserDao;
import com.clipper.model.LikeDTO;
import com.clipper.model.Post;
import com.clipper.model.User;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostControllerTest {
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("config2.xml");
	
	private static User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private static Post post = new Post(0, "James is great", user, null, null);
	private static LikeDTO dto = new LikeDTO(0, 1, 1);
	private static PostDao pd =  ac.getBean(PostDao.class);
	private static LikeDao ld =  ac.getBean(LikeDao.class);
	private static UserDao ud =  ac.getBean(UserDao.class);
	private static PostController pc = ac.getBean(PostController.class);
	
	@BeforeClass
	public static void prepare() {
		
		
		ud.save(user);
		User u = ud.findUserByUsername("Jmann");
		post =  new Post(0, "James is great",u, null, null);
		pd.save(post);
	}
	
	
	@Test
	public void A_AllPostsTest() {
		pc.getAllPosts();
		
	}
	@Test
	public void B_getPostTest() {
		pc.getPost(pd.findAll().get(0).getId());
	}
	@Test
	public void C_getPostsByUser() {
		pc.getPostsByUser(ud.findUserByUsername("Jmann").getId());
	}
	@Test
	public void D_UpdatePost() {
		pc.updatePost(pd.findAll().get(0), ud.findUserByUsername("Jmann").getId(), pd.findAll().get(0).getId());
	}
	@Test
	public void Z_deletePost() {
		pc.deletePost(pd.findAll().get(0).getId());
	}
	@AfterClass
	public static void cleanUp() {
		pd.deleteAll();
		ud.deleteAll();
		ld.deleteAll();
	}

}