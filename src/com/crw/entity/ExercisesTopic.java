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
 * ExercisesTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exercises_topic", catalog = "crw_data")
public class ExercisesTopic implements java.io.Serializable {

	// Fields

	private Long exercisesId;
	private User user;
	private Course course;
	private String exercisesName;
	private String exercisesPath;
	private Timestamp date;
	private Integer DTimes;
	private String exercisesContent;
	private Float exercisesScore;
	private String checkAdvice;
	private String isChecked;

	// Constructors

	/** default constructor */
	public ExercisesTopic() {
	}

	/** minimal constructor */
	public ExercisesTopic(Long exercisesId, User user, Course course,
			String exercisesName, String exercisesPath, Timestamp date,
			Integer DTimes, String isChecked) {
		this.exercisesId = exercisesId;
		this.user = user;
		this.course = course;
		this.exercisesName = exercisesName;
		this.exercisesPath = exercisesPath;
		this.date = date;
		this.DTimes = DTimes;
		this.isChecked = isChecked;
	}

	/** full constructor */
	public ExercisesTopic(Long exercisesId, User user, Course course,
			String exercisesName, String exercisesPath, Timestamp date,
			Integer DTimes, String exercisesContent, Float exercisesScore,
			String checkAdvice, String isChecked) {
		this.exercisesId = exercisesId;
		this.user = user;
		this.course = course;
		this.exercisesName = exercisesName;
		this.exercisesPath = exercisesPath;
		this.date = date;
		this.DTimes = DTimes;
		this.exercisesContent = exercisesContent;
		this.exercisesScore = exercisesScore;
		this.checkAdvice = checkAdvice;
		this.isChecked = isChecked;
	}

	// Property accessors
	@Id
	@Column(name = "exercises_id", unique = true, nullable = false)
	public Long getExercisesId() {
		return this.exercisesId;
	}

	public void setExercisesId(Long exercisesId) {
		this.exercisesId = exercisesId;
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

	@Column(name = "exercises_name", nullable = false, length = 100)
	public String getExercisesName() {
		return this.exercisesName;
	}

	public void setExercisesName(String exercisesName) {
		this.exercisesName = exercisesName;
	}

	@Column(name = "exercises_path", nullable = false, length = 100)
	public String getExercisesPath() {
		return this.exercisesPath;
	}

	public void setExercisesPath(String exercisesPath) {
		this.exercisesPath = exercisesPath;
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

	@Column(name = "exercises_content", length = 2000)
	public String getExercisesContent() {
		return this.exercisesContent;
	}

	public void setExercisesContent(String exercisesContent) {
		this.exercisesContent = exercisesContent;
	}

	@Column(name = "exercises_score", precision = 255, scale = 0)
	public Float getExercisesScore() {
		return this.exercisesScore;
	}

	public void setExercisesScore(Float exercisesScore) {
		this.exercisesScore = exercisesScore;
	}

	@Column(name = "check_advice", length = 2000)
	public String getCheckAdvice() {
		return this.checkAdvice;
	}

	public void setCheckAdvice(String checkAdvice) {
		this.checkAdvice = checkAdvice;
	}

	@Column(name = "is_checked", nullable = false, length = 1)
	public String getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

}