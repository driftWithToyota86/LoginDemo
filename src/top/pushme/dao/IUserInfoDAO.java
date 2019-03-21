package top.pushme.dao;

import top.pushme.domain.UserInfo;

public interface IUserInfoDAO {

	/*
	 * get userinfo 
	 * @param 
	 */
	public UserInfo getUser();
	
	/*
	 * save userinfo
	 * @param userinfo save this
	 */
	public void saveUser(UserInfo uInfo);
	
	public void updateUser();
	
	public void deleteUser();
}
