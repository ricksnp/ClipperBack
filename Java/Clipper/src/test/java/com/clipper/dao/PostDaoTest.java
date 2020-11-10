package com.clipper.dao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
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
	
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private Post post = new Post(0, "James is great",user, null, null);
	private static UserDao ud = ac.getBean(UserDao.class);
	private static PostDao pd = ac.getBean(PostDao.class);
	
	@Before
	public void prepare() throws Exception {
		ud.save(user);

		
	}
	
	@Test
	public void A_CreatePost() {
		assertEquals(post, pd.save(post));
	}
	@Test
	public void B_FindAllPosts() {
		assertEquals(2, pd.findAll().get(0).getId());
	}
	@Test
	public void C_FindPostByID() {
		assertEquals(2,pd.findById(2).getId());
	}
	@Test
	public void D_Update() {
		assertEquals(post.getId(),pd.update(post).getId());
	}

	@Test
	public void E_Delete() {
		assertEquals(pd.findById(2).getId(),pd.delete(2).getId());
	}
	
	@AfterClass
	public static void Z_DeleteAll() {
		pd.deleteAll();
		ud.deleteAll();
	}
	
}
