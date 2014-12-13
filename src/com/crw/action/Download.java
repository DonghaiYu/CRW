package com.crw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.crw.dao.ResourceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Download extends ActionSupport {

	private String fileName;
	private String path;
	private String id;

	private ResourceDAO resourceDAO;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}

	@Resource(name = "resourceDAO")
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() throws UnsupportedEncodingException {
		return new String(fileName.getBytes(), "iso-8859-1");
	}

	public void setFileName(String fileName)
			throws UnsupportedEncodingException {

		this.fileName = fileName;
	}

	// 返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流
	public InputStream getDownloadFile() throws Exception {

		FileInputStream fileInputStream = new FileInputStream(new File(
				ServletActionContext.getServletContext().getRealPath("") + "\\"
						+ path + fileName));

		resourceDAO.downloadTimesAddById(Long.parseLong(id));
		return fileInputStream;
	}

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
}
