package com.crw.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crw.constant.CRWC;
import com.crw.constant.Md5;
import com.crw.entity.User;
import com.crw.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String loginid;
	private String loginpassword;
	
	private LoginService loginService;


	
	public String execute() throws Exception {
		
		//System.out.println("从登陆页面取得：id "+loginid+" 密码"+loginpassword);
		
		List<User> result = loginService.check(Long.parseLong(loginid),Md5.trans(loginpassword));
		if(result.size() == CRWC.ZERO) {
			//System.out.println("未找到用户");
			addActionError("用户名或密码错误！");
			return CRWC.FAIL;
		}else{
			User u = result.get(0);
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user",u);
			if(u.getType() == CRWC.ADMIN){
				//System.out.println("角色为管理员");
				return CRWC.ADM;
			}else if (u.getType() == CRWC.TEACHER) {
				//System.out.println("角色为老师");
				return CRWC.TEA;
			}else if (u.getType() == CRWC.STUDENT) {
				//System.out.println("角色为学生");

				return CRWC.STU;
			}
			
		}
		return CRWC.FAIL;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginpassword() {
		return loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	public LoginService getLoginService() {
		return loginService;
	}
	@Resource
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
}
