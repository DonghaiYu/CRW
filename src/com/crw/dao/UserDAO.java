package com.crw.dao;

import java.util.List;

import com.crw.entity.User;


public interface UserDAO {
	public List<User> findUser(long id,String password);
	public String changePassword(long id,String oldpass,String newpass);
	public List<User> findUserOf(int num);
	public int toGetUserNum();
	public User findUserById(long id);
	public boolean updateUser(User user);
	public boolean addUser(User user);
	public boolean deleteUserById(long id);
}
