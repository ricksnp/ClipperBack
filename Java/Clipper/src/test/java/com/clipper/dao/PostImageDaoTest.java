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
import com.clipper.model.PostImage;
import com.clipper.model.User;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostImageDaoTest {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("config2.xml");
	
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private Post post = new Post(0, "James is great",user, null, null);
	private PostImage postImage = new PostImage(0,"img.link",post);
	private static UserDao ud = ac.getBean(UserDao.class);
	private static PostDao pd = ac.getBean(PostDao.class);
	private static PostImageDao pid = ac.getBean(PostImageDao.class);
	@Before
	public void prepare() throws Exception {
		ud.save(user);
		pd.save(post);
	}
	@Test
	public void A_CreatePostImage() {
		assertEquals(postImage, pid.save(postImage));
	}
	@Test
	public void B_FindAllPostImage() {
		assertEquals(22, pid.findAll().get(0).getId());
	}
	@Test
	public void C_FindPostImageById() {
		assertEquals(22,pid.findById(22).getId());
	}
	@Test
	public void D_UpdatePostImage() {
		assertEquals(postImage, pid.update(postImage));
	}
	@Test
	public void E_DeletePostImage() {
		assertEquals(pid.findById(22).getId(),pid.delete(22).getId());
	}
	@AfterClass
	public static void Z_DeleteAll() {
		pid.deleteAll();
		pd.deleteAll();
		ud.deleteAll();
	}

}
