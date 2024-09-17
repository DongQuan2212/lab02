package vn.iostar.dao;

import java.util.List;

import vn.iostar.Models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);

	void update(UserModel user);

	UserModel findByUserName(String username);

	UserModel checkExistEmail(String email);
	
	UserModel checkExistUsername(String username);
	
	void register( String username, String email, String password);
	

}
