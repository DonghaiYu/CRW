package com.crw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.crw.dao.UserDAO;
import com.crw.entity.User;


@Component
public class LoginService {
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> check(long id,String password){
		System.out.println("到达LoginService ");		
		return userDAO.findUser(id, password);
	}
}
