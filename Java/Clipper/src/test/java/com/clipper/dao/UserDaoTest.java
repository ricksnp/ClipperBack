package com.clipper.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.clipper.model.User;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
	private User user = new User(0,"Jmann","wasspord","James","James","james@james.net","My name Jeff", "#", new HashSet<>(), new HashSet<>());
	private static UserDao ud = new UserDao();
	@Test
	public void A_CreateUser() {
		assertEquals(user, ud.save(user));
	}
	@Test
	public void B_FindAllUser() {
		assertEquals(20,ud.findAll().get(0).getId());
	}
	@Test
	public void C_FindUserById() {
		assertEquals(20,ud.findById(20).getId());
	}
	@Test
	public void D_UpdateUser() {
		assertEquals(user.getId(), ud.update(user).getId());
	}
	@AfterClass
	public static void Z_DeleteAll() {
		for(int i = 0; i<20; i++) {
			ud.delete(i);
		}
	}

}
