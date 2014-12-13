package com.crw.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crw.service.LoadCourseService;
import com.opensymphony.xwork2.ActionSupport;

public class LoadCoursesAction extends ActionSupport {
	private LoadCourseService loadCourseService;

	
	public LoadCourseService getLoadCourseService() {
		return loadCourseService;
	}

	@Resource
	public void setLoadCourseService(LoadCourseService loadCourseService) {
		this.loadCourseService = loadCourseService;
	}


	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse(); 
        response.setCharacterEncoding("utf-8"); 
        PrintWriter out = response.getWriter(); 
       String string =  loadCourseService.toGetList();
        
        out.print(string); 
        out.flush(); 
        out.close();
		return null;
	}
}
