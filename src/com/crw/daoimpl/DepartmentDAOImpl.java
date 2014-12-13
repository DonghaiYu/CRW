package com.crw.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.crw.dao.BaseDAO;
import com.crw.dao.DepartmetDAO;
import com.crw.entity.Course;
import com.crw.entity.Department;


@Component("depatmentDAO")
public class DepartmentDAOImpl extends BaseDAO implements DepartmetDAO {
	@Override
	public List<Department> findAllforZtree() {
		System.out.println("DepartmentDAOImpl");
		List<Department> result = null;
		Session session = this.getCurrentSession();
			
		Query q = session.createQuery("from Department");
		result = (List<Department>)q.list();
		
		
		//System.out.println("找到部门数目："+result.size());

		return result;
	}
	@Override
	public Set<Course> toGetMember(long id){
		Set<Course> result = null;
		Session session = this.getCurrentSession();
			
		Query q = session.createQuery("from Department d where d.id = :id");
		q.setLong("id", id);
		result =((Department)q.list().get(0)).getCourses();
	
		
		//System.out.println("该部门拥有课程数目："+result.size());
	
		return result;
		
	}
	@Override
	public Department findDepartmentById(long id) {
		Session session = this.getCurrentSession();
		
		Department department = (Department) session.get(Department.class, id);
		session.close();
		return department;
	}
	@Override
	public boolean addDepartment(Department department) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.save(department);
		session.getTransaction().commit();
		session.close();		
		return true;
	}
	@Override
	public boolean deleteById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Department department = (Department) session.get(Department.class, id);
		if(department != null){
			session.delete(department);
		}
		session.getTransaction().commit();
		session.close();		
		return true;
	}
	@Override
	public boolean update(Department department) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.update(department);
		session.getTransaction().commit();
		session.close();
		return true;
	}


}
