package com.crw.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.crw.constant.CRWC;
import com.crw.dao.DepartmetDAO;
import com.crw.entity.Course;
import com.crw.entity.Department;

@Component
public class DepartmentService {
	private DepartmetDAO departmetDAO;

	public String toGetDepartmentList(){
		List<Department> list = departmetDAO.findAllforZtree();
		JSONArray childs = new JSONArray(); 
        JSONObject child = new JSONObject();
        for(int i=CRWC.ZERO;i<list.size();i++){
        	child.put("id", list.get(i).getId());
        	child.put("name", list.get(i).getName());
        	childs.add(child);
        }
		return childs.toString();
	}
	
	public DepartmetDAO getDepartmetDAO() {
		return departmetDAO;
	}
	@Resource(name="depatmentDAO")
	public void setDepartmetDAO(DepartmetDAO departmetDAO) {
		this.departmetDAO = departmetDAO;
	}
}
