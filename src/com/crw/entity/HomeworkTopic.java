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
 * HomeworkTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "homework_topic", catalog = "crw_data")
public class HomeworkTopic implements java.io.Serializable {

	// Fields

	private Long homeworkId;
	private User user;
	private Course course;
	private String homeworkName;
	private String homeworkPath;
	private Timestamp date;
	private Integer DTimes;

	// Constructors

	/** default constructor */
	public HomeworkTopic() {
	}

	/** minimal constructor */
	public HomeworkTopic(Long homeworkId, Course course, String homeworkName,
			String homeworkPath, Timestamp date, Integer DTimes) {
		this.homeworkId = homeworkId;
		this.course = course;
		this.homeworkName = homeworkName;
		this.homeworkPath = homeworkPath;
		this.date = date;
		this.DTimes = DTimes;
	}

	/** full constructor */
	public HomeworkTopic(Long homeworkId, User user, Course course,
			String homeworkName, String homeworkPath, Timestamp date,
			Integer DTimes) {
		this.homeworkId = homeworkId;
		this.user = user;
		this.course = course;
		this.homeworkName = homeworkName;
		this.homeworkPath = homeworkPath;
		this.date = date;
		this.DTimes = DTimes;
	}

	// Property accessors
	@Id
	@Column(name = "homework_id", unique = true, nullable = false)
	public Long getHomeworkId() {
		return this.homeworkId;
	}

	public void setHomeworkId(Long homeworkId) {
		this.homeworkId = homeworkId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "corse_id", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "homework_name", nullable = false, length = 100)
	public String getHomeworkName() {
		return this.homeworkName;
	}

	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}

	@Column(name = "homework_path", nullable = false, length = 100)
	public String getHomeworkPath() {
		return this.homeworkPath;
	}

	public void setHomeworkPath(String homeworkPath) {
		this.homeworkPath = homeworkPath;
	}

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "d_times", nullable = false)
	public Integer getDTimes() {
		return this.DTimes;
	}

	public void setDTimes(Integer DTimes) {
		this.DTimes = DTimes;
	}

}