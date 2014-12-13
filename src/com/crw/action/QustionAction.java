package com.crw.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crw.constant.ResolveState;
import com.crw.entity.Question;
import com.crw.entity.User;
import com.crw.service.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class QustionAction extends ActionSupport{
	
	private int id;
	private String name;
	private int userId;
	private int teacherId;
	private int status;
	private int flag;
	private String reply;
	private String text;
	
	private List<Question> questions;
	private List<Question> resolvedQuestions;
	private List<Question> suggests;
	private Question question;
	
	private QuestionService questionService;
	
	
	public String insert() throws Exception {
		Question question = new Question();
		question.setName(name);
		question.setText(text);
		question.setFlag(flag);
		question.setStatus(0);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
	    User user = (User)session.getAttribute("user"); 
	    
		question.setStuId(user.getId());
		question.setTime(new Date());
		questionService.insertQuestion(question);
		return "success";
	}
	public String update()throws Exception {
		Question question = questionService.getQustionById(id);
		question.setName(name);
		question.setText(text);
		questionService.updateQuestion(question);
		return "success";	
	}

	
	public String delete() throws Exception {
		questionService.deleteQuestion(id);
        return "success";
		
	}

	public String getAllQuestion() throws Exception{
		this.setQuestions(questionService.getQuestions(ResolveState.UNSOLVE));
		this.setResolvedQuestions(questionService.getQuestions(ResolveState.RESOLVED));
		this.setSuggests(questionService.getSuggests());
		
		return returnStr();
		
	}

	public String getQuestionById() throws Exception{
		Question question = questionService.getQustionById(id);
		this.setQuestion(question);
		return returnStr();
	}

	public String reply() throws Exception{
		questionService.replyQuestion(id, reply);
		return "success";
		
	}

	private String returnStr(){
		HttpSession session = ServletActionContext.getRequest().getSession();
	    User user = (User)session.getAttribute("user"); 
		String returnStr = "";
	    if(user.getType()==2){
	    	returnStr ="student";
	    }else if (user.getType()==1){
	    	returnStr = "teacher";
	    }
	    return returnStr;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}


	public String getReply() {
		return reply;
	}


	public void setReply(String reply) {
		this.reply = reply;
	}


	public QuestionService getQuestionService() {
		return questionService;
	}


	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


	public List<Question> getResolvedQuestions() {
		return resolvedQuestions;
	}


	public void setResolvedQuestions(List<Question> resolvedQuestions) {
		this.resolvedQuestions = resolvedQuestions;
	}


	public List<Question> getSuggests() {
		return suggests;
	}


	public void setSuggests(List<Question> suggests) {
		this.suggests = suggests;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	

}
