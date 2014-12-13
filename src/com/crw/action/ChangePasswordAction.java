package com.crw.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crw.constant.CRWC;
import com.crw.constant.Md5;
import com.crw.service.ChangePasswordService;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport {
		private String oldpass;
		private String newpass;
		private ChangePasswordService changePasswordService;
		
		public ChangePasswordService getChangePasswordService() {
			return changePasswordService;
		}
		@Resource
		public void setChangePasswordService(ChangePasswordService changePasswordService) {
			this.changePasswordService = changePasswordService;
		}
	
		public String getOldpass() {
			return oldpass;
		}
		public void setOldpass(String oldpass) {
			this.oldpass = oldpass;
		}
		public String getNewpass() {
			return newpass;
		}
		public void setNewpass(String newpass) {
			this.newpass = newpass;
		}
		@Override
		public String execute() throws Exception {
			HttpServletResponse response = ServletActionContext.getResponse(); 
	        response.setCharacterEncoding("utf-8"); 
	        PrintWriter out = response.getWriter(); 
	        
			String result =changePasswordService.changeFromTo(Md5.trans(oldpass),Md5.trans(newpass)); 
			if(result.equals(CRWC.SUCCESS)){
				this.addActionError("密码修改成功！");
				out.print("密码修改成功！");
			}else{
				if(result.equals(CRWC.WRONGPASS)){
					this.addActionError("原密码错误！");
					out.print("原密码错误！");
				}else {
					this.addActionError("密码修改失败！");

					out.print("密码修改失败！");
				}
				
			}
			out.flush(); 
		    out.close();
			return null;
		}
}
