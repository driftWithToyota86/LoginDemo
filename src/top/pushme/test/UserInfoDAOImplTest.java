package top.pushme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import top.pushme.dao.IUserInfoDAO;
import top.pushme.dao.impl.UserInfoDAOImpl;
import top.pushme.domain.UserInfo;

public class UserInfoDAOImplTest {

	
	

	@Test
	public void testGetUser() {
		IUserInfoDAO iUserInfoDAO = new UserInfoDAOImpl();
		UserInfo ui = iUserInfoDAO.getUser();
		System.out.println("userInfo:" + ui.getUsername());

	}

	@Test
	public void testSaveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
