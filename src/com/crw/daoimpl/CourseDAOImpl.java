package com.crw.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.crw.dao.BaseDAO;
import com.crw.dao.CourseDAO;
import com.crw.entity.Course;
import com.crw.entity.Department;

@Component("courseDAO")
public class CourseDAOImpl extends BaseDAO implements CourseDAO {

	@Override
	public List<Course> findAll() {
		//System.out.println("CourseDAOImpl");
		List<Course> result = null;
		Session session = this.getCurrentSession();
			
		Query q = session.createQuery("from Course");
		result = (List<Course>)q.list();
		//System.out.println("找到课程总数："+result.size());

		return result;
	}
	@Override
	public Course findById(long id){
		List<Course> result = null;
		Session session = this.getCurrentSession();
				
		Query q = session.createQuery("from Course c where c.id = "+id);
		result = (List<Course>)q.list();
		
		session.close();
		return result.get(0);
	}
	@Override
	public boolean addCourse(Course course) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		return true;
	}
	@Override
	public boolean deleteById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Course course = (Course) session.get(Course.class, id);
		if(course != null){
			session.delete(course);
			
		}
		session.getTransaction().commit();
		session.close();		
		return true;
	}
	@Override
	public boolean update(Course course) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.update(course);
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
