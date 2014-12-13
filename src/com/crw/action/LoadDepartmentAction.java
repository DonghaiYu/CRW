package com.crw.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crw.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

public class LoadDepartmentAction extends ActionSupport {

	private DepartmentService departmentService;
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public String execute() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse(); 
        response.setCharacterEncoding("utf-8"); 
        PrintWriter out = response.getWriter(); 
       String string =  departmentService.toGetDepartmentList();
        
        out.print(string); 
        out.flush(); 
        out.close();
		return null;
	}
	
}
