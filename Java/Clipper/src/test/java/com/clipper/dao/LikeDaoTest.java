package com.clipper.dao;





import com.clipper.model.Like;
import com.clipper.model.Post;
import com.clipper.model.User;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeDaoTest {
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", null, null, null);
	private Post post = new Post(0, "James is great", user, null, null);
	private Like l = new Like(0,post,user);
	private LikeDao ld;
	
	@Before
	public void prepare() throws Exception {
		ld =  new LikeDao();
	}
	
	@Test
	public void A_CreateLike() { //Create
		assertEquals(l, ld.save(l));
		 
	}

}
