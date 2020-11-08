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
		assertEquals(1,ud.findAll().get(0).getId());
	}
	@Test
	public void C_FindUserById() {
		assertEquals(1,ud.findById(1).getId());
	}
	@Test
	public void D_UpdateUser() {
		assertEquals(user.getId(), ud.update(user).getId());
	}
	@Test
	public void E_DeleteUser() {
		assertEquals(ud.findById(1).getId(),ud.delete(1).getId());
	}
	@AfterClass
	public static void Z_DeleteAll() {
		ud.deleteAll();
	}

}
