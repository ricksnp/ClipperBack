package com.clipper.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.clipper.model.Post;
import com.clipper.model.User;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostDaoTest {


	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private Post post = new Post(0, "James is great",user, new HashSet<>(), new HashSet<>());
	private static UserDao ud = new UserDao();
	private static PostDao pd = new PostDao();
	
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
		assertEquals(12, pd.findAll().get(0).getId());
	}
	@Test
	public void C_FindPostByID() {
		assertEquals(12,pd.findById(12).getId());
	}
	@Test
	public void D_Update() {
		assertEquals(post.getId(),pd.update(post).getId());
	}

	@AfterClass
	public static void Z_DeleteAll() {
		for(int i = 0; i<20; i++) {
			pd.delete(i);
		
		}
		for(int i = 0; i<20; i++) {
			ud.delete(i);
		}
		assertTrue(true);
	}
}
