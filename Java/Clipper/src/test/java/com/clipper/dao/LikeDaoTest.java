package com.clipper.dao;





import com.clipper.model.Like;
import com.clipper.model.Post;
import com.clipper.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeDaoTest {
	
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private Post post = new Post(0, "James is great", user, null, null);
	private static UserDao ud = new UserDao();
	private static PostDao pd = new PostDao();
	private Like l = new Like(0,post,user);
	private LikeDao ld;
	
	@Before
	public void prepare() throws Exception {
		ud.save(user);
		pd.save(post);
		ld =  new LikeDao();
	}
	
	@Test
	public void A_CreateLike() { //Create
		assertEquals(l, ld.save(l));
	}
	@Test
	public void B_FindAllLikes() {
		List<Like> ll = new ArrayList<>();
		ll.add(l);
		assertEquals(ll.get(0).getLikeId(), ld.findAll().get(0).getLikeId());
	}
	@Test
	public void Z_DeleteAll() {
		for(int i = 0; i<20; i++) {
			ud.deleteforrealzies(i);
			pd.deleteforrealsies(i);;
		}
		assertTrue(true);
	}
	

}
