package com.crw.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crw.constant.CRWC;
import com.opensymphony.xwork2.ActionSupport;

public class ExitAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		return CRWC.SUCCESS;
	}
	
}
