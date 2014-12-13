package com.crw.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * HomeworkAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "homework_answer", catalog = "crw_data")
public class HomeworkAnswer implements java.io.Serializable {

	// Fields

	private Long answerId;
	private User user;
	private Course course;
	private String answerName;
	private String answerPath;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public HomeworkAnswer() {
	}

	/** full constructor */
	public HomeworkAnswer(Long answerId, User user, Course course,
			String answerName, String answerPath, Timestamp date) {
		this.answerId = answerId;
		this.user = user;
		this.course = course;
		this.answerName = answerName;
		this.answerPath = answerPath;
		this.date = date;
	}

	// Property accessors
	@Id
	@Column(name = "answer_id", unique = true, nullable = false)
	public Long getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "answer_name", nullable = false, length = 100)
	public String getAnswerName() {
		return this.answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	@Column(name = "answer_path", nullable = false, length = 100)
	public String getAnswerPath() {
		return this.answerPath;
	}

	public void setAnswerPath(String answerPath) {
		this.answerPath = answerPath;
	}

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}