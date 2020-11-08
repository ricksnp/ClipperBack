package com.clipper.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.clipper.model.Post;
import com.clipper.model.PostImage;
import com.clipper.model.User;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostImageDaoTest {
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private Post post = new Post(0, "James is great",user, new HashSet<>(), new HashSet<>());
	private PostImage postImage = new PostImage(0,"img.link",post);
	private static UserDao ud = new UserDao();
	private static PostDao pd = new PostDao();
	private static PostImageDao pid = new PostImageDao();
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
		assertEquals(19, pid.findAll().get(0).getId());
	}
	@Test
	public void C_FindPostImageById() {
		assertEquals(19,pid.findById(19).getId());
	}
	@Test
	public void D_UpdatePostImage() {
		assertEquals(postImage, pid.update(postImage));
	}
	@AfterClass
	public static void Z_DeleteAll() {
		for(int i = 0; i<20; i++) {
			pid.delete(i);
		}
		for(int i = 0; i<20; i++) {
			pd.delete(i);
		
		}
		for(int i = 0; i<20; i++) {
			ud.delete(i);
		}
		
	}

}
