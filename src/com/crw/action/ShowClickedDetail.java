package com.crw.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crw.constant.CRWC;
import com.crw.dao.DepartmetDAO;
import com.crw.dao.ResourceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ShowClickedDetail extends ActionSupport {
	private ResourceDAO resourceDAO;
	private DepartmetDAO departmetDAO;

	private List<com.crw.entity.Resource> all;
	
	private int currentPage;
	private int pageNum;
	private int resultNum;
	private String queryCondition;
	
	
	public int getResultNum() {
		return resultNum;
	}
	public void setResultNum(int resultNum) {
		this.resultNum = resultNum;
	}

	
	
	public String getQueryCondition() {
		return queryCondition;
	}
	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
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
	public List<com.crw.entity.Resource> getAll() {
		return all;
	}
	public void setAll(List<com.crw.entity.Resource> all) {
		this.all = all;
	}
	
	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}
	@Resource
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}
	
	

	public DepartmetDAO getDepartmetDAO() {
		return departmetDAO;
	}
	@Resource(name="depatmentDAO")
	public void setDepartmetDAO(DepartmetDAO departmetDAO) {
		this.departmetDAO = departmetDAO;
	}
	@Override
	public String execute() throws Exception {
		
		String id = ServletActionContext.getRequest().getParameter("id");
		HttpSession session = ServletActionContext.getRequest().getSession(); 
		if(id != null){
			System.out.println("details  of "+":" +id);
			String[] m = id.split("_");
			if(m[0].equals("c") && m[1] != null){
				
				session.setAttribute("showType", CRWC.SHOWTYPE_ID);
				session.setAttribute("courseId", m[1]);
				currentPage = CRWC.FIRSTPAGE;
				resultNum = resourceDAO.toGetNumForOneCourse(Long.parseLong(m[1]));
				pageNum =(( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1);
				this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());

				all = resourceDAO.toGetMembers(Long.parseLong(m[1]),currentPage);
			}
		}
		return "success";
	}
	public String searchExecute(){
		HttpSession session = ServletActionContext.getRequest().getSession(); 

		//设置显示状态为条件查询
		session.setAttribute("showType", CRWC.SHOWTYPE_SEARCH);
		//将查询条件存入session
		session.setAttribute("queryCondition", queryCondition);
		//pageNum = resourceDAO.toGetNumForOneCourse(Long.parseLong(m[1]));
		currentPage = CRWC.FIRSTPAGE;
		resultNum = resourceDAO.resultNumOfSearch(queryCondition, currentPage);
		pageNum =(( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1);
		this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());
		all = resourceDAO.searchFor(queryCondition, currentPage);
		return CRWC.SUCCESS;
	}
	
	public String gotoPageOf(){
		HttpSession session = ServletActionContext.getRequest().getSession(); 

		String 	showType =	session.getAttribute("showType").toString();
		if(showType.equals(CRWC.SHOWTYPE_ID)){
			//当前为查找某课程内资源状态
			long id = Long.parseLong(ServletActionContext.getRequest().getSession().getAttribute("courseId").toString());
			resultNum = resourceDAO.toGetNumForOneCourse(id);
			pageNum =(( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1);
			this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());

			all = resourceDAO.toGetMembers(id,currentPage);
			
		}else if(showType.equals(CRWC.SHOWTYPE_SEARCH)){
			//当前为条件查找状态
			queryCondition = ServletActionContext.getRequest().getSession().getAttribute("queryCondition").toString();
			resultNum = resourceDAO.resultNumOfSearch(queryCondition, currentPage);
			pageNum =(( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1);
			this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());

			all = resourceDAO.searchFor(queryCondition, currentPage);
		}
		return CRWC.SUCCESS;
	}

}
