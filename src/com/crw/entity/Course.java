package com.crw.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", catalog = "crw_data")
public class Course implements java.io.Serializable {

	// Fields

	private Long id;
	private Department department;
	private String bookname;
	private Integer examType;
	private Integer hours;
	private String name;
	private Set<HomeworkTopic> homeworkTopics = new HashSet<HomeworkTopic>(0);
	private Set<TestTopic> testTopics = new HashSet<TestTopic>(0);
	private Set<TestAnswer> testAnswers = new HashSet<TestAnswer>(0);
	private Set<TC> TCs = new HashSet<TC>(0);
	private Set<ExercisesAnswer> exercisesAnswers = new HashSet<ExercisesAnswer>(
			0);
	private Set<ExercisesTopic> exercisesTopics = new HashSet<ExercisesTopic>(0);
	private Set<HomeworkAnswer> homeworkAnswers = new HashSet<HomeworkAnswer>(0);
	private Set<Resource> resources = new HashSet<Resource>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Department department, Integer examType, Integer hours,
			String name) {
		this.department = department;
		this.examType = examType;
		this.hours = hours;
		this.name = name;
	}

	/** full constructor */
	public Course(Department department, String bookname, Integer examType,
			Integer hours, String name, Set<HomeworkTopic> homeworkTopics,
			Set<TestTopic> testTopics, Set<TestAnswer> testAnswers,
			Set<TC> TCs, Set<ExercisesAnswer> exercisesAnswers,
			Set<ExercisesTopic> exercisesTopics,
			Set<HomeworkAnswer> homeworkAnswers, Set<Resource> resources) {
		this.department = department;
		this.bookname = bookname;
		this.examType = examType;
		this.hours = hours;
		this.name = name;
		this.homeworkTopics = homeworkTopics;
		this.testTopics = testTopics;
		this.testAnswers = testAnswers;
		this.TCs = TCs;
		this.exercisesAnswers = exercisesAnswers;
		this.exercisesTopics = exercisesTopics;
		this.homeworkAnswers = homeworkAnswers;
		this.resources = resources;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "bookname")
	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Column(name = "exam_type", nullable = false)
	public Integer getExamType() {
		return this.examType;
	}

	public void setExamType(Integer examType) {
		this.examType = examType;
	}

	@Column(name = "hours", nullable = false)
	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<HomeworkTopic> getHomeworkTopics() {
		return this.homeworkTopics;
	}

	public void setHomeworkTopics(Set<HomeworkTopic> homeworkTopics) {
		this.homeworkTopics = homeworkTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<TestTopic> getTestTopics() {
		return this.testTopics;
	}

	public void setTestTopics(Set<TestTopic> testTopics) {
		this.testTopics = testTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<TestAnswer> getTestAnswers() {
		return this.testAnswers;
	}

	public void setTestAnswers(Set<TestAnswer> testAnswers) {
		this.testAnswers = testAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<TC> getTCs() {
		return this.TCs;
	}

	public void setTCs(Set<TC> TCs) {
		this.TCs = TCs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<ExercisesAnswer> getExercisesAnswers() {
		return this.exercisesAnswers;
	}

	public void setExercisesAnswers(Set<ExercisesAnswer> exercisesAnswers) {
		this.exercisesAnswers = exercisesAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<ExercisesTopic> getExercisesTopics() {
		return this.exercisesTopics;
	}

	public void setExercisesTopics(Set<ExercisesTopic> exercisesTopics) {
		this.exercisesTopics = exercisesTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<HomeworkAnswer> getHomeworkAnswers() {
		return this.homeworkAnswers;
	}

	public void setHomeworkAnswers(Set<HomeworkAnswer> homeworkAnswers) {
		this.homeworkAnswers = homeworkAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

}