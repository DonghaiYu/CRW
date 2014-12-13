package com.crw.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crw.constant.CRWC;
import com.crw.dao.ResourceDAO;
import com.crw.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetMyResourcesAction extends ActionSupport {

	private ResourceDAO resourceDAO;
	private int currentPage;
	private int pageNum;
	private int resultNum;
	private List<com.crw.entity.Resource> allMyRes;
	
	public List<com.crw.entity.Resource> getAllMyRes() {
		return allMyRes;
	}
	public void setAllMyRes(List<com.crw.entity.Resource> allMyRes) {
		this.allMyRes = allMyRes;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getResultNum() {
		return resultNum;
	}
	public void setResultNum(int resultNum) {
		this.resultNum = resultNum;
	}
	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}
	@Resource(name="resourceDAO")
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}
	@Override
	public String execute() throws Exception {
		if(currentPage < CRWC.FIRSTPAGE){
			this.setCurrentPage(CRWC.FIRSTPAGE);
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		resultNum = resourceDAO.toGetNumForOneUser(user.getId());
		pageNum =(( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1);
		this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());
		allMyRes = resourceDAO.toGetUsersResById(user.getId(),currentPage);
		//System.out.println("currentpage:"+currentPage);
		return CRWC.SUCCESS;
	}
	
}
