package com.crw.service;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.crw.dao.ResourceDAO;

@Component
public class DeleteResService {
	private ResourceDAO resourceDAO;

	public boolean DeleteResourceById(long id){
		
		
		com.crw.entity.Resource r = resourceDAO.deleteById(id);
		if(r != null){
			File toDeleteFile = new File(ServletActionContext.getServletContext().getRealPath("")+"\\"+r.getPath(), r.getName());
			if(toDeleteFile.exists()){
				toDeleteFile.delete();
				return true;
			}
		}
		
		
		return false;
	}
	
	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}
	@Resource
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}
}
