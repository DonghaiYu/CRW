package com.crw.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.crw.constant.CRWC;
import com.crw.dao.CourseDAO;
import com.crw.entity.Course;

@Component
public class LoadCourseService {
	private CourseDAO courseDAO;
	
	public String toGetList(){
		System.out.println("loadcourseService");
		List<Course> list = courseDAO.findAll();
		JSONArray childs = new JSONArray(); 
        JSONObject child = new JSONObject();
        for(int i=CRWC.ZERO;i<list.size();i++){
        	child.put("id", list.get(i).getId());
        	child.put("name", list.get(i).getName());
        	childs.add(child);
        }
		return childs.toString();
	}
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	@Resource(name = "courseDAO")
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
}
