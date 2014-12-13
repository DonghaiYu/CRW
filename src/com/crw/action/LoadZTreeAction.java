package com.crw.action;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crw.service.LoadZTree;
import com.opensymphony.xwork2.ActionSupport;

public class LoadZTreeAction extends ActionSupport {

	private LoadZTree loadZTree; 
	public LoadZTree getloadZTree() {
		return loadZTree;
	}
	@Resource
	public void setloadZTree(LoadZTree loadZTree) {
		this.loadZTree = loadZTree;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("loadZTreeAction");
		HttpServletResponse response = ServletActionContext.getResponse(); 
        response.setCharacterEncoding("utf-8"); 
        PrintWriter out = response.getWriter(); 
       String string =  loadZTree.findAll();
        
        out.print(string); 
        out.flush(); 
        out.close();
		return null;
	}
}
