package com.crw.action;

import java.util.List;

import com.crw.constant.CRWC;
import com.crw.entity.Resource;
import com.crw.service.ManageService;
import com.opensymphony.xwork2.ActionSupport;

public class ResourcesManageAction extends ActionSupport {
	
	private List<Resource> resources;
	private ManageService manageService;
	private int pageNum;
	private int resultNum;
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getResultNum() {
		return resultNum;
	}
	public void setResultNum(int resultNum) {
		this.resultNum = resultNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public ManageService getManageService() {
		return manageService;
	}
	@javax.annotation.Resource
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}

	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	@Override
	public String execute() throws Exception {
		if(currentPage < CRWC.FIRSTPAGE ){
			this.setCurrentPage(CRWC.FIRSTPAGE);
		}
		this.setResources(manageService.findResourcesOf(currentPage));		
		this.setResultNum(manageService.toGetItemNum());
		this.setPageNum((( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1));
		this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());
		return CRWC.SUCCESS;
	}
		
}
