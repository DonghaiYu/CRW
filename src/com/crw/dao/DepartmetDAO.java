package com.crw.dao;

import java.util.List;
import java.util.Set;

import com.crw.entity.Course;
import com.crw.entity.Department;

public interface DepartmetDAO {
	public List<Department> findAllforZtree();
	public Set<Course> toGetMember(long id);
	public Department findDepartmentById(long id);
	public boolean addDepartment(Department department);
	public boolean deleteById(long id);
	public boolean update(Department department);
}
