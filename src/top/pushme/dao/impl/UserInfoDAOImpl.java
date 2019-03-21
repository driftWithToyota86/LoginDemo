package top.pushme.dao.impl;

import top.pushme.dao.IUserInfoDAO;
import top.pushme.domain.UserInfo;
import top.pushme.handler.BeanHandler;
import top.pushme.template.JDBCTemplate;

public class UserInfoDAOImpl implements IUserInfoDAO {

	@Override
	public UserInfo getUser() {
		// TODO Auto-generated method stub
		System.out.println("1");
		String sql = "SELECT * FROM t_userinfo WHERE id = ?";
		Object params[] = {2};
		System.out.println("params:" + params);
		return JDBCTemplate.query(sql, new BeanHandler<>(UserInfo.class), params);
		
	}

	@Override
	public void saveUser(UserInfo uInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}
	

}
