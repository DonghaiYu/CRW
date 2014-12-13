package com.crw.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crw.constant.CRWC;
import com.crw.dao.BaseDAO;
import com.crw.dao.UserDAO;
import com.crw.entity.User;

@Component("userDAO")
public class UserDAOImpl extends BaseDAO implements UserDAO {
	@Override
	@Transactional
	public List<User> findUser(long id, String password) {

		Session session = super.getCurrentSession();	
		Query q = session.createQuery("from User u where u.id = :id and u.password = :password");
		q.setLong("id",id);
		q.setString("password", password);
		List<User> result = (List<User>)q.list();
		session.close();
		return result;
	}

	@Override
	public String changePassword(long id ,String oldpass, String newpass) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, id);
		if(user != null){
			if(!user.getPassword().equals(oldpass)){
				session.getTransaction().commit();	

				return CRWC.WRONGPASS;
			}else {
				user.setPassword(newpass);
				session.update(user);
				session.getTransaction().commit();	

				return CRWC.SUCCESS;
			}
			
		}
		session.getTransaction().commit();	
		
		return CRWC.FAIL;
	}
	
	public List<User> findUserOf(int num){
		Session session = this.getCurrentSession();
		
		Query q = session.createQuery("from User where type = 1 or type = 2");
		q.setFirstResult((num -1) *CRWC.PAGESIZE);
		q.setMaxResults(CRWC.PAGESIZE);
		List<User> result = (List<User>)q.list();

		return result;
	}

	@Override
	public int toGetUserNum() {
		Session session = this.getCurrentSession();
	
		Query q = session.createQuery("from User where type = 1 or type = 2");
		int num = q.list().size();

		return num;
	}

	@Override
	public User findUserById(long id) {
		Session session = this.getCurrentSession();
	
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();

		return true;
	}
	
	public boolean addUser(User user){
		Session session = this.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteUserById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, id);
		if(user != null){
			session.delete(user);
		}
		
		session.getTransaction().commit();
		return true;
	}

}
