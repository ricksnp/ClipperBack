package com.clipper.zcontroller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.clipper.controller.LikeController;
import com.clipper.dao.LikeDao;
import com.clipper.dao.PostDao;
import com.clipper.dao.UserDao;
import com.clipper.model.LikeDTO;
import com.clipper.model.Post;
import com.clipper.model.User;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeControllerTest {
	private static User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private static Post post = new Post(0, "James is great", user, null, null);
	private static LikeDTO dto = new LikeDTO(0, 0, 0);
	private static PostDao pd;
	private static LikeDao ld = new LikeDao();
	private static UserDao ud = new UserDao();
	LikeController lc = new LikeController();
	
	@BeforeClass
	public static void prepare() {
		pd = new PostDao();
		post =  new Post(0, "James is great",user, null, null);
		pd.save(post);
		ud.save(user);
	}
	
	
	@Test
	public void A_AddLikeTest() {
		lc.addLike(dto);
	}
	
	@AfterClass
	public static void cleanUp() {
		pd.deleteAll();
		ud.deleteAll();
		ld.deleteAll();
	}

}
