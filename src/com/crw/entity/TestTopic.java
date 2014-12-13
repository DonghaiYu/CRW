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
 * TestTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "test_topic", catalog = "crw_data")
public class TestTopic implements java.io.Serializable {

	// Fields

	private Long testId;
	private User user;
	private Course course;
	private String testName;
	private String testPath;
	private Timestamp date;
	private Integer DTimes;

	// Constructors

	/** default constructor */
	public TestTopic() {
	}

	/** minimal constructor */
	public TestTopic(Long testId, User user, Course course, String testName,
			String testPath, Timestamp date) {
		this.testId = testId;
		this.user = user;
		this.course = course;
		this.testName = testName;
		this.testPath = testPath;
		this.date = date;
	}

	/** full constructor */
	public TestTopic(Long testId, User user, Course course, String testName,
			String testPath, Timestamp date, Integer DTimes) {
		this.testId = testId;
		this.user = user;
		this.course = course;
		this.testName = testName;
		this.testPath = testPath;
		this.date = date;
		this.DTimes = DTimes;
	}

	// Property accessors
	@Id
	@Column(name = "test_id", unique = true, nullable = false)
	public Long getTestId() {
		return this.testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
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

	@Column(name = "test_name", nullable = false, length = 100)
	public String getTestName() {
		return this.testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Column(name = "test_path", nullable = false, length = 100)
	public String getTestPath() {
		return this.testPath;
	}

	public void setTestPath(String testPath) {
		this.testPath = testPath;
	}

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "d_times")
	public Integer getDTimes() {
		return this.DTimes;
	}

	public void setDTimes(Integer DTimes) {
		this.DTimes = DTimes;
	}

}