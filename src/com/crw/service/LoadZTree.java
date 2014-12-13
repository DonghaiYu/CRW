package com.crw.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.crw.constant.CRWC;
import com.crw.dao.CourseDAO;
import com.crw.dao.DepartmetDAO;
import com.crw.entity.Course;
import com.crw.entity.Department;
@Component
public class LoadZTree {
	private DepartmetDAO departmetDAO;
	private CourseDAO courseDAO;
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	@Resource(name = "courseDAO")
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	public DepartmetDAO getDepartmetDAO() {
		return departmetDAO;
	}
	@Resource(name = "depatmentDAO")
	public void setDepartmetDAO(DepartmetDAO departmetDAO) {
		this.departmetDAO = departmetDAO;
	}
	
	public String findAll(){
		System.out.println("DepartmentService");
		List<Department> list = departmetDAO.findAllforZtree();
		List<Course> list2 = courseDAO.findAll();
		
		JSONArray childs = new JSONArray(); 
        JSONObject child = new JSONObject();
        for(int i=CRWC.ZERO;i<list.size();i++){
        	child.put("id", "d_"+list.get(i).getId());
        	child.put("pId",0);
        	child.put("name", list.get(i).getName());
        	child.put("url", "showDetail.action?id="+"d_"+list.get(i).getId());
        	child.put("target", "showdetaile_iframe");
        	childs.add(child);
        }
        for(int i=CRWC.ZERO;i<list2.size();i++){
        	child.put("id", "c_"+list2.get(i).getId());
        	child.put("pId","d_"+list2.get(i).getDepartment().getId());
        	child.put("name", list2.get(i).getName());
        	child.put("url", "showDetail.action?id="+"c_"+list2.get(i).getId());
        	child.put("target", "showdetaile_iframe");
        	childs.add(child);
        }
        //System.out.println(childs.toString());
		return childs.toString();
	}
}
