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
import com.clipper.model.User;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostDaoTest {

	private static ApplicationContext ac = new ClassPathXmlApplicationContext("config2.xml");
	
	static private User user = new User(0,"Jmann","wasspord","James","James","Goddamnitworkyoubitch@james.net","My name Jeff", "#", null, null);
	static private Post post;
	private static UserDao ud = ac.getBean(UserDao.class);
	private static PostDao pd = ac.getBean(PostDao.class);
	
	@BeforeClass
	public static void prepare() throws Exception {
		ud.save(user);
		User u = ud.findAll().get(0);
		post = new Post(0, "James is great",u, null, null);
	}
	
	@Test
	public void A_CreatePost() {
		assertEquals(post, pd.save(post));
	}
	@Test
	public void B_FindAllPosts() {
		assertEquals(1, pd.findAll().get(0).getId());
	}
	@Test
	public void C_FindPostByID() {
		assertEquals(1,pd.findById(1).getId());
	}
	@Test
	public void D_Update() {
		assertEquals(post.getId(),pd.update(post).getId());
	}

	@Test
	public void E_Delete() {
		assertEquals(pd.findById(1).getId(),pd.delete(1).getId());
	}
	
	@AfterClass
	public static void Z_DeleteAll() {
		pd.deleteAll();
		ud.deleteAll();
	}
	
}
