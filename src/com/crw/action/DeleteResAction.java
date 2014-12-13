package com.crw.action;

import javax.annotation.Resource;

import com.crw.constant.CRWC;
import com.crw.service.DeleteResService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteResAction extends ActionSupport {

	private DeleteResService deleteResService;
	public DeleteResService getDeleteResService() {
		return deleteResService;
	}
	@Resource
	public void setDeleteResService(DeleteResService deleteResService) {
		this.deleteResService = deleteResService;
	}
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		//System.out.println("to delete"+id);

        if(deleteResService.DeleteResourceById(Long.parseLong(id))){
        	return CRWC.SUCCESS;
        }
        this.addActionError("删除出错！");
		return CRWC.SUCCESS;
	}
	
	public String deleteResById(){

        if(deleteResService.DeleteResourceById(Long.parseLong(id))){
        	return CRWC.ADMINSUCCESS;
        }
        this.addActionError("删除出错！");
		return CRWC.ADMINSUCCESS;
	}
	
}
