package vn.iostar.services.impl;
import vn.iostar.Models.UserModel;

import vn.iostar.dao.impl.UserDaoimpl;
import vn.iostar.services.IUserService;

public class UserServiceimpl implements IUserService {
	UserDaoimpl userDao = new UserDaoimpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
		}
	@Override
	public UserModel FindByUserName(String username) {
		
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}



}
