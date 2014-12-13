package com.crw.dao;

import java.util.List;

import com.crw.entity.Course;

public interface CourseDAO {
	public List<Course> findAll();
	public Course findById(long id);
	public boolean addCourse(Course course);
	public boolean deleteById(long id);
	public boolean update(Course course);
}
