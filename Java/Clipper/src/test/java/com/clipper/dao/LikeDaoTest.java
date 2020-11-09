package com.clipper.dao;





import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clipper.model.Like;
import com.clipper.model.Post;
import com.clipper.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeDaoTest {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("config2.xml");
	
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", null, null);
	private Post post = new Post(0, "James is great", user, null, null);
	private static UserDao ud = ac.getBean(UserDao.class);
	private static PostDao pd = ac.getBean(PostDao.class);
	private Like l = new Like(0,post,user);
	private static LikeDao ld = ac.getBean(LikeDao.class);
	
	@Before
	public void prepare() throws Exception {
		ud.save(user);
		pd.save(post);
		
	}
	
	@Test
	public void A_CreateLike() { //Create
		assertEquals(l, ld.save(l));
	}
	@Test
	public void B_FindAllLikes() {
		assertEquals(3, ld.findAll().get(0).getLikeId());
	}
	@Test
	public void C_FindById() {
		assertEquals(3, ld.findById(3).getLikeId());
	}
	@Test
	public void D_Update() {
		assertEquals(l.getLikeId(),ld.update(l).getLikeId());
	}
	@Test
	public void E_Delete() {
		assertEquals(ld.findById(3),ld.delete(3));
	}
	@AfterClass
	public static void Z_DeleteAll() {
		ld.deleteAll();
		pd.deleteAll();
		ud.deleteAll();
		assertTrue(true);
	}
	

}
