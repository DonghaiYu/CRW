package com.crw.daoimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.crw.constant.CRWC;
import com.crw.dao.BaseDAO;
import com.crw.dao.ResourceDAO;
import com.crw.entity.Course;
import com.crw.entity.Resource;
import com.crw.entity.User;

@Component("resourceDAO")
public class ResourceDAOImpl extends BaseDAO implements ResourceDAO {

	@Override
	public void downloadTimesAddById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Resource temp = (Resource) session.get(Resource.class, id);
		temp.setDTimes(temp.getDTimes() + 1);
		session.update(temp);
		session.getTransaction().commit();

	}

	@Override
	public List<Resource> toGetMembers(long id, int pnum) {
		Set<Resource> temp = null;
		Session session = this.getCurrentSession();

		Query q = session.createQuery("from Course c where c.id = :id");
		q.setLong("id", id);
		temp = ((Course) q.list().get(0)).getResources();
		List<Resource> r = new ArrayList<Resource>(temp);
		List<Resource> result = null;
		result = r.subList(
				(pnum - 1) * CRWC.PAGESIZE,
				(pnum * CRWC.PAGESIZE) < r.size() ? (pnum * CRWC.PAGESIZE) : r
						.size());

		// System.out.println("该 课程拥有资源数目："+result.size());

		return result;

	}

	@Override
	public void uploadOne(Resource resource) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.save(resource);
		session.getTransaction().commit();

	}

	@Override
	public List<Resource> toGetUsersResById(long id, int pnum) {
		Set<Resource> result = null;
		Session session = this.getCurrentSession();

		result = ((User) session.get(User.class, id)).getResources();

		List<Resource> r = new ArrayList<Resource>(result);
		Collections.sort(r);
		r = r.subList((pnum - 1) * CRWC.PAGESIZE, (pnum * CRWC.PAGESIZE) < r
				.size() ? (pnum * CRWC.PAGESIZE) : r.size());

		return r;
	}

	@Override
	public Resource deleteById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Resource resource = (Resource) session.get(Resource.class, id);
		if (resource != null) {
			session.delete(resource);
		}
		session.getTransaction().commit();

		return resource;
	}

	@Override
	public List<Resource> toGetResourcesOf(int num) {
		Session session = this.getCurrentSession();

		Query q = session.createQuery("from Resource");
		q.setFirstResult((num - 1) * CRWC.PAGESIZE);
		q.setMaxResults(CRWC.PAGESIZE);
		List<Resource> result = q.list();

		return result;
	}

	@Override
	public int toGetItemNum() {
		Session session = this.getCurrentSession();

		Query q = session.createQuery("from Resource");
		int num = q.list().size();

		return num;
	}

	@Override
	public String toGetTypeById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		String type = ((Resource) session.get(Resource.class, id)).getType();
		session.getTransaction().commit();

		return type;
	}

	@Override
	public int toGetNumForOneCourse(long id) {

		Session session = this.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Course c where c.id = :id");
		q.setLong("id", id);

		int num = ((Course) q.list().get(0)).getResources().size();
		session.getTransaction().commit();

		return num;
	}

	@Override
	public List<Resource> searchFor(String queryCondition, int pnum) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Query q = null;
		if (queryCondition.equals("") || queryCondition == null) {
			q = session.createQuery("from Resource");
		} else {
			q = session.createQuery("from Resource where name like :que");
			q.setString("que", "%" + queryCondition + "%");

		}
		q.setFirstResult((pnum - 1) * CRWC.PAGESIZE);
		q.setMaxResults(CRWC.PAGESIZE);
		List<Resource> result = q.list();
		session.getTransaction().commit();

		return result;
	}

	@Override
	public int resultNumOfSearch(String queryCondition, int pnum) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Query q = null;
		if (queryCondition.equals("") || queryCondition == null) {
			q = session.createQuery("from Resource");
		} else {
			q = session.createQuery("from Resource where name like :que");
			q.setString("que", "%" + queryCondition + "%");
		}
		int num = q.list().size();
		session.getTransaction().commit();

		return num;
	}

	@Override
	public int toGetNumForOneUser(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from User  where id = :id");
		q.setLong("id", id);

		int num = ((User) q.list().get(0)).getResources().size();
		session.getTransaction().commit();

		return num;
	}

}
