package com.crw.action;

import java.util.List;

import javax.annotation.Resource;

import com.crw.constant.CRWC;
import com.crw.entity.User;
import com.crw.service.ManageService;
import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends ActionSupport {
	private ManageService manageService;
	private List<User> users;
	
	private int currentPage;
	private int pageNum;
	private int resultNum;
	private int deleteId;
	private long edit_id;
	private String edit_username;
	private boolean edit_sex;
	private long edit_tel;
	private String edit_email;
	private long edit_department;
	private String edit_password;
	private int edit_type;
	private String add_username;
	private boolean add_sex;
	private long add_tel;
	private String add_email;
	private long add_department;
	private String add_password;
	private int add_type;
	
	public String getAdd_username() {
		return add_username;
	}
	public void setAdd_username(String add_username) {
		this.add_username = add_username;
	}
	public boolean isAdd_sex() {
		return add_sex;
	}
	public void setAdd_sex(boolean add_sex) {
		this.add_sex = add_sex;
	}
	public long getAdd_tel() {
		return add_tel;
	}
	public void setAdd_tel(long add_tel) {
		this.add_tel = add_tel;
	}
	public String getAdd_email() {
		return add_email;
	}
	public void setAdd_email(String add_email) {
		this.add_email = add_email;
	}
	public long getAdd_department() {
		return add_department;
	}
	public void setAdd_department(long add_department) {
		this.add_department = add_department;
	}
	public String getAdd_password() {
		return add_password;
	}
	public void setAdd_password(String add_password) {
		this.add_password = add_password;
	}
	public int getAdd_type() {
		return add_type;
	}
	public void setAdd_type(int add_type) {
		this.add_type = add_type;
	}
	public long getEdit_id() {
		return edit_id;
	}
	public void setEdit_id(long edit_id) {
		this.edit_id = edit_id;
	}
	public String getEdit_username() {
		return edit_username;
	}
	public void setEdit_username(String edit_username) {
		this.edit_username = edit_username;
	}
	public boolean isEdit_sex() {
		return edit_sex;
	}
	public void setEdit_sex(boolean edit_sex) {
		this.edit_sex = edit_sex;
	}
	public long getEdit_tel() {
		return edit_tel;
	}
	public void setEdit_tel(long edit_tel) {
		this.edit_tel = edit_tel;
	}
	public String getEdit_email() {
		return edit_email;
	}
	public void setEdit_email(String edit_email) {
		this.edit_email = edit_email;
	}
	public long getEdit_department() {
		return edit_department;
	}
	public void setEdit_department(long edit_department) {
		this.edit_department = edit_department;
	}
	public String getEdit_password() {
		return edit_password;
	}
	public void setEdit_password(String edit_password) {
		this.edit_password = edit_password;
	}
	public int getEdit_type() {
		return edit_type;
	}
	public void setEdit_type(int edit_type) {
		this.edit_type = edit_type;
	}
	public int getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public ManageService getManageService() {
		return manageService;
	}
	@Resource
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}
	@Override
	public String execute() throws Exception {
		this.setCurrentPage((currentPage < CRWC.FIRSTPAGE)? CRWC.FIRSTPAGE : currentPage);
		this.setResultNum(manageService.toGetUserNum());
		pageNum =(( resultNum % CRWC.PAGESIZE) == 0)? (resultNum / CRWC.PAGESIZE) :(resultNum / CRWC.PAGESIZE +1);
		this.setPageNum((this.getPageNum() < 1 )? 1 : this.getPageNum());

		this.setUsers(manageService.findUsersOf(currentPage));
		return CRWC.SUCCESS;
	}
	public String editUser(){
		manageService.updateUserMessage(edit_id, edit_username, edit_sex, edit_tel, edit_email, edit_department, edit_password,edit_type);
		return CRWC.USEREDITSUCCESS;
	}
	public String deleteUser(){
		//System.out.println(deleteId);
		if(manageService.deleteUserById(deleteId)){
			return CRWC.SUCCESS;
		}
		return CRWC.SUCCESS;
	}
	
	public String addUser(){
		manageService.addUser(add_username, add_sex, add_tel, add_email, add_department, add_password, add_type);
		return CRWC.USEREDITSUCCESS;
	}
}
