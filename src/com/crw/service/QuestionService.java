package com.crw.service;

import java.util.ArrayList;
import java.util.List;

import com.crw.constant.ResolveState;
import com.crw.dao.QuestionDao;
import com.crw.entity.Question;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	private QuestionDao questionDao;

	public List<Question> getQuestions(ResolveState state){
		return questionDao.getQuestions(state);
	}
	public List<Question> getSuggests(){
		return questionDao.getSuggests();
	}
 	public Question getQustionById(long id){
		return questionDao.getQustionById(id);
	}
	public void insertQuestion(Question question){
		questionDao.insertQuestion(question);
	}
	public void deleteQuestion(long id){
		questionDao.deleteQuestion(id);
	}
	public void updateQuestion(Question question){
		questionDao.updateQuestion(question);
	}
	public void replyQuestion(long id,String reply){
		questionDao.replyQuestion(id, reply);
	}
	public QuestionDao getQuestionDao() {
		return questionDao;
	}
	@Resource(name="questionDao")
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	

}
