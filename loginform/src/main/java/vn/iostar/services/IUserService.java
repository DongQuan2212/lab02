package vn.iostar.services;

import vn.iostar.Models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);
	
	void insert(UserModel user);
	


}
