package com.crw.action;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.crw.constant.CRWC;
import com.crw.dao.CourseDAO;
import com.crw.dao.ResourceDAO;
import com.crw.entity.Course;
import com.crw.entity.Resource;
import com.crw.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private String selectcourse;
	private CourseDAO courseDAO;
	private ResourceDAO resourceDAO;
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;
	
	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}
	@javax.annotation.Resource(name="resourceDAO")
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}
	
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getSelectcourse() {
		return selectcourse;
	}
	public void setSelectcourse(String selectcourse) {
		this.selectcourse = selectcourse;
	}
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	@javax.annotation.Resource(name="courseDAO")
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	
	@Override
	public String execute() throws Exception {
		if(uploadFileFileName==null){
			addActionError("请选择文件!");
			return CRWC.SUCCESS;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			long userid = user.getId();
			String target = ServletActionContext.getServletContext().getRealPath("resources/r_"+userid);
			File tagetFile = new File(target, uploadFileFileName);
			if(tagetFile.exists()){
				addActionError("文件已经存在!");
				return CRWC.SUCCESS;
			}
			FileUtils.copyFile(uploadFile, tagetFile);
		
			Course blongsToCourse = courseDAO.findById(Long.parseLong(selectcourse));
			
			Resource newresource = new Resource();
			newresource.setCourse(blongsToCourse);
			newresource.setDate(new Timestamp(System.currentTimeMillis()));
			newresource.setDTimes((long) 0);
			newresource.setName(uploadFileFileName);
			newresource.setUser(user);
			newresource.setPath("resources\\r_"+userid+"\\");
			newresource.setType(uploadFileContentType);
			resourceDAO.uploadOne(newresource);
			
			System.out.println("uploaded!");
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter outjs = response.getWriter();
			outjs.print("<script>alert('上传成功');window.location.reload();</script>");
		}
		if(user.getType() == 0){
			return CRWC.ADMINSUCCESS;
		}
		return CRWC.SUCCESS;
	}
}
