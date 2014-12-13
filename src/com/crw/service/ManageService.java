package com.crw.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.crw.constant.Md5;
import com.crw.dao.CourseDAO;
import com.crw.dao.DepartmetDAO;
import com.crw.dao.ResourceDAO;
import com.crw.dao.UserDAO;
import com.crw.entity.Course;
import com.crw.entity.Department;
import com.crw.entity.User;

@Component
public class ManageService {
	private ResourceDAO resourceDAO;
	private UserDAO userDAO;
	private DepartmetDAO departmetDAO;
	private CourseDAO courseDAO;
	
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	@Resource(name="courseDAO")
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	public DepartmetDAO getDepartmetDAO() {
		return departmetDAO;
	}
	@Resource(name="depatmentDAO")
	public void setDepartmetDAO(DepartmetDAO departmetDAO) {
		this.departmetDAO = departmetDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}
	@Resource(name="resourceDAO")
	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}
	
	public List<com.crw.entity.Resource> findResourcesOf(int num){
		return resourceDAO.toGetResourcesOf(num);
	}
	public int toGetItemNum(){
		return resourceDAO.toGetItemNum();
	}
	
	public List<User>  findUsersOf(int num){
		return userDAO.findUserOf(num);
	}
	
	public int toGetUserNum(){
		return userDAO.toGetUserNum();
	}
	
	public boolean updateUserMessage(long id,String username,boolean sex,long tel,String email,long department,String password,int type){
		User newUser = userDAO.findUserById(id);
		newUser.setUsername(username);
		newUser.setDepartment(departmetDAO.findDepartmentById(department));
		newUser.setEmail(email);
		newUser.setSex(sex);
		newUser.setTel(tel);
		newUser.setType(type);
		
		if(!password.equals("") && password != null){
			newUser.setPassword(Md5.trans(password));
		}
		
		userDAO.updateUser(newUser);
		return true;
	}
	
	public boolean addUser(String username,boolean sex,long tel,String email,long department,String password,int type){
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setDepartment(departmetDAO.findDepartmentById(department));
		newUser.setEmail(email);
		newUser.setSex(sex);
		newUser.setTel(tel);
		newUser.setType(type);
		newUser.setRDate(new Timestamp(System.currentTimeMillis()));
		newUser.setState(true);
		newUser.setPassword(Md5.trans(password));

		
		userDAO.addUser(newUser);
		return true;
	}
	
	public boolean deleteUserById(long id){
		userDAO.deleteUserById(id);
		return true;
	}
	
	public List<Department> togetAllDepartment(){
		return departmetDAO.findAllforZtree();
	}
	
	public List<Course> togetAllCourses(){
		return courseDAO.findAll();
	}
	
	public boolean addDepartment(String name,int snum,int tnum){
		Department department = new Department();
		department.setName(name);
		department.setStudentSum(snum);
		department.setTeacherSum(tnum);
		return departmetDAO.addDepartment(department);
		
	}
	
	public boolean deleteDepartmentById(long id){
		return departmetDAO.deleteById(id);
	}
	
	public boolean updateDepartment(String name,long id,int snum,int tnum){
		Department department = departmetDAO.findDepartmentById(id);
		if(department != null){
			department.setName(name);
			department.setStudentSum(snum);
			department.setTeacherSum(tnum);
			departmetDAO.update(department);
		}
		return true;
	}
	
	public boolean addCourse(String name,int hours,int examType,long departmentId,String book){
		Course course = new Course();
		course.setDepartment(departmetDAO.findDepartmentById(departmentId));
		course.setName(name);
		course.setExamType(examType);
		course.setHours(hours);
		course.setBookname(book);
		courseDAO.addCourse(course);
		return true;
	}
	
	public boolean deleteCourseById(long id){
		return courseDAO.deleteById(id);
	}
	
	public boolean updateCourse(long id,String name,int examType,int hours,long departmentid,String book){
		Course course = courseDAO.findById(id);
		if (course != null) {
			course.setName(name);
			course.setExamType(examType);
			course.setBookname(book);
			course.setHours(hours);
			course.setDepartment(departmetDAO.findDepartmentById(departmentid));
			courseDAO.update(course);
		}
		return true;
	}
}
