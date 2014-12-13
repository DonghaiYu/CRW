package com.crw.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.crw.constant.CRWC;
import com.crw.dao.UserDAO;
import com.crw.entity.User;

@Component
public class ChangePasswordService {
	
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String changeFromTo(String oldpass,String newpass){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		long userid = user.getId();
		String r =  userDAO.changePassword(userid, oldpass, newpass);
		if(r.equals(CRWC.SUCCESS)){
			user.setPassword(newpass);
			session.setAttribute("user", user);
		}
		return r;
	}
}
