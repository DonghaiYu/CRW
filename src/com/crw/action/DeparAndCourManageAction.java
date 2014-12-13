package com.crw.action;

import java.util.List;

import javax.annotation.Resource;

import com.crw.constant.CRWC;
import com.crw.entity.Course;
import com.crw.entity.Department;
import com.crw.service.ManageService;
import com.opensymphony.xwork2.ActionSupport;

public class DeparAndCourManageAction extends ActionSupport {
	private ManageService manageService;
	private List<Department> departments;
	private List<Course> courses;
	private String addDeName;
	private int addDeSNum;
	private int addDeTNum;
	
	private String addCName;
	private int addCHour;
	private int addCExamType;
	private long addCDepartment;
	private String addCBook;

	private long deleteDId;
	
	private String editDeName;
	private int editDeSNum;
	private int editDeTNum;
	private long editDeId;
	
	private long deleteCId;
	
	/*editCName").val(name);
 	  jQuery("#editCHour").val(hours);
 	  jQuery("#editCExamType").val(examtype);
 	  jQuery("#editCDepartment").val(departmentid);
 	  jQuery("#editCBook").val(book);
 	  jQuery("#editCourId").val(id);
    jQuery("#editCourse").show();*/
	
	private String editCName;
	private int editCHour;
	private int editCExamType;
	private long editCDepartment;
	private String editCBook;
	private long editCourId;

	
	public String getEditCName() {
		return editCName;
	}
	public void setEditCName(String editCName) {
		this.editCName = editCName;
	}
	public int getEditCHour() {
		return editCHour;
	}
	public void setEditCHour(int editCHour) {
		this.editCHour = editCHour;
	}
	public int getEditCExamType() {
		return editCExamType;
	}
	public void setEditCExamType(int editCExamType) {
		this.editCExamType = editCExamType;
	}
	public long getEditCDepartment() {
		return editCDepartment;
	}
	public void setEditCDepartment(long editCDepartment) {
		this.editCDepartment = editCDepartment;
	}
	public String getEditCBook() {
		return editCBook;
	}
	public void setEditCBook(String editCBook) {
		this.editCBook = editCBook;
	}
	public long getEditCourId() {
		return editCourId;
	}
	public void setEditCourId(long editCourId) {
		this.editCourId = editCourId;
	}
	public long getDeleteCId() {
		return deleteCId;
	}
	public void setDeleteCId(long deleteCId) {
		this.deleteCId = deleteCId;
	}
	public long getEditDeId() {
		return editDeId;
	}
	public void setEditDeId(long editDeId) {
		this.editDeId = editDeId;
	}
	public String getEditDeName() {
		return editDeName;
	}
	public void setEditDeName(String editDeName) {
		this.editDeName = editDeName;
	}
	public int getEditDeSNum() {
		return editDeSNum;
	}
	public void setEditDeSNum(int editDeSNum) {
		this.editDeSNum = editDeSNum;
	}
	public int getEditDeTNum() {
		return editDeTNum;
	}
	public void setEditDeTNum(int editDeTNum) {
		this.editDeTNum = editDeTNum;
	}
	public long getDeleteDId() {
		return deleteDId;
	}
	public void setDeleteDId(long deleteDId) {
		this.deleteDId = deleteDId;
	}
	public String getAddDeName() {
		return addDeName;
	}
	public void setAddDeName(String addDeName) {
		this.addDeName = addDeName;
	}
	public int getAddDeSNum() {
		return addDeSNum;
	}
	public void setAddDeSNum(int addDeSNum) {
		this.addDeSNum = addDeSNum;
	}
	public int getAddDeTNum() {
		return addDeTNum;
	}
	public void setAddDeTNum(int addDeTNum) {
		this.addDeTNum = addDeTNum;
	}
	public String getAddCName() {
		return addCName;
	}
	public void setAddCName(String addCName) {
		this.addCName = addCName;
	}
	public int getAddCHour() {
		return addCHour;
	}
	public void setAddCHour(int addCHour) {
		this.addCHour = addCHour;
	}
	public int getAddCExamType() {
		return addCExamType;
	}
	public void setAddCExamType(int addCExamType) {
		this.addCExamType = addCExamType;
	}
	public long getAddCDepartment() {
		return addCDepartment;
	}
	public void setAddCDepartment(long addCDepartment) {
		this.addCDepartment = addCDepartment;
	}
	public String getAddCBook() {
		return addCBook;
	}
	public void setAddCBook(String addCBook) {
		this.addCBook = addCBook;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
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
		this.setDepartments(manageService.togetAllDepartment());
		this.setCourses(manageService.togetAllCourses());
		return CRWC.SUCCESS;
	}
	
	public String addDepartment(){
		if(manageService.addDepartment(addDeName, addDeSNum, addDeTNum)){
			return CRWC.ADDSUCCESS;
		}
		return CRWC.ADDSUCCESS;
	}
	
	public String deleteDepartment(){
		if(manageService.deleteDepartmentById(deleteDId)){
			return CRWC.ADDSUCCESS;
		}
		return CRWC.ADDSUCCESS;
	}
	
	public String editDepartment(){
		if(manageService.updateDepartment( editDeName,editDeId, editDeSNum, editDeTNum)){
			return CRWC.ADDSUCCESS;
		}
		return CRWC.ADDSUCCESS;
	}
	
	public String addCourse(){
		if(manageService.addCourse(addCName, addCHour, addCExamType, addCDepartment, addCBook)){
			return CRWC.ADDSUCCESS;
		}
		return CRWC.ADDSUCCESS;
	}
	public String deleteCourse(){
		if(manageService.deleteCourseById(deleteCId)){
			return CRWC.ADDSUCCESS;
		}
		return CRWC.ADDSUCCESS;
	}
	public String editCourse(){
		if(manageService.updateCourse(editCourId, editCName, editCExamType, editCHour, editCDepartment, editCBook)){
			return CRWC.ADDSUCCESS;
		}
		return CRWC.ADDSUCCESS;
	}
}
