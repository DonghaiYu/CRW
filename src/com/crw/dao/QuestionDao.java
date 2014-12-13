package com.crw.dao;

import java.util.List;

import com.crw.constant.ResolveState;
import com.crw.entity.Question;

public interface QuestionDao {
	List<Question> getQuestions(ResolveState state);
	List<Question> getSuggests();
 	Question getQustionById(long id);
	void insertQuestion(Question question);
	void deleteQuestion(long id);
	void updateQuestion(Question question);
	void replyQuestion(long id,String reply);
}
