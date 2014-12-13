package com.crw.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.crw.constant.ResolveState;
import com.crw.dao.BaseDAO;
import com.crw.dao.QuestionDao;
import com.crw.entity.Question;
import com.crw.entity.User;

@Component("questionDao")
public class QuestionDaoImpl extends BaseDAO implements QuestionDao{

	@Override
	public void updateQuestion(Question question) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		if(question!=null){
			session.update(question);
			session.getTransaction().commit();
		}	
		
	}

	@Override
	public void deleteQuestion(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Question question = getQustionById(id);
		if(question!=null){
			session.delete(question);
			session.getTransaction().commit();
		}	
	}

	@Override
	public List<Question> getQuestions(ResolveState state) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Question q where q.status= :status and flag = 0");
		q.setInteger("status", state.getCode());
		List<Question> result = (List<Question>)q.list();
		session.getTransaction().commit();	
		return result;
	}

	@Override
	public Question getQustionById(long id) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from Question q where q.id= :id ");
		q.setLong("id", id);
		List<Question> result = (List<Question>)q.list();
		session.getTransaction().commit();	
		return result.isEmpty()?null:result.get(0);
	}

	@Override
	public void insertQuestion(Question question) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		if(question!=null){
			session.save(question);
			session.getTransaction().commit();
		}	
	}

	@Override
	public void replyQuestion(long id, String reply) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Question question = getQustionById(id);
		if(question!=null){
			question.setReply(reply);
			question.setStatus(ResolveState.RESOLVED.getCode());
			session.update(question);
			session.getTransaction().commit();
		}	
	}

	@Override
	public List<Question> getSuggests() {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Question q where q.flag = 1 ");
		List<Question> result = (List<Question>)q.list();
		session.getTransaction().commit();	
		return result;
	}

}
