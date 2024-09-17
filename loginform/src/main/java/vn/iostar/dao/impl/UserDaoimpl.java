package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.Models.UserModel;
import vn.iostar.confligs.DBConnectMySQL;
import vn.iostar.dao.IUserDao;

public class UserDaoimpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> users = new ArrayList<>();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserModel user = new UserModel();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		// UserModel users = new UserModel();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserModel user = new UserModel();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users (?,username, email, password, roleid) VALUES (?,?,?,?,?)";
				try {
				conn = super.getConnection();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, user.getId());
				preparedStatement.setString(2, user.getUsername());
				preparedStatement.setString(3, user.getEmail());
				preparedStatement.setString(4, user.getPassword());
				preparedStatement.setInt(5,user.getRoleid());
				preparedStatement.executeQuery();
				} catch (Exception e) {e.printStackTrace();}
				}

	@Override
	public void update(UserModel user) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		UserModel user = new UserModel();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}


	

	@Override
	public UserModel checkExistEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ? ";
		UserModel user = new UserModel();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public UserModel checkExistUsername(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		UserModel user = new UserModel();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				user.setRoleid(resultSet.getInt("roleid"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	
	@Override
	public void register(  String username, String email, String password) {
		String sql = "INSERT INTO users (username, email, password) VALUES (?,?,?)";
		UserModel user = new UserModel();
		try {
			conn = super.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}		
	}
	public static void main(String[] args) {
		try {
			UserDaoimpl userDao = new  UserDaoimpl();			
			
			userDao.register("hnt", "hnt", "hnt");	
			List<UserModel> list = userDao.findAll();
			
			for (UserModel user : list) {
				System.out.println(user);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}




	
	
	


