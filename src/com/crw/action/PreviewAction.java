package com.crw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.crw.dao.ResourceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PreviewAction extends ActionSupport {

	private String fileName;  
    private String path;
    private String id;
    private ResourceDAO resourceDAO;
    public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}
    @Resource(name="resourceDAO")
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public InputStream getPreviewFile() throws Exception  
    {  
		String type = resourceDAO.toGetTypeById(Long.parseLong(id));
    	ServletActionContext.getResponse().addHeader("content-type",type);
     	FileInputStream fileInputStream = new FileInputStream(new File(ServletActionContext.getServletContext().getRealPath("")+"\\"+path+fileName));
    	return fileInputStream;
   } 
    
	public String getFileName() throws UnsupportedEncodingException {
		return new String(fileName.getBytes(),"iso-8859-1");
		
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

}
