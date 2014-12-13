package com.crw.entity;

import java.sql.Timestamp;
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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "crw_data")
public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private Department department;
	private Timestamp RDate;
	private String email;
	private String password;
	private Boolean sex;
	private Boolean state;
	private Long tel;
	private Integer type;
	private String username;
	private Set<TestAnswer> testAnswers = new HashSet<TestAnswer>(0);
	private Set<Resource> resources = new HashSet<Resource>(0);
	private Set<TestTopic> testTopics = new HashSet<TestTopic>(0);
	private Set<ExercisesAnswer> exercisesAnswers = new HashSet<ExercisesAnswer>(
			0);
	private Set<ExercisesTopic> exercisesTopics = new HashSet<ExercisesTopic>(0);
	private Set<HomeworkAnswer> homeworkAnswers = new HashSet<HomeworkAnswer>(0);
	private Set<HomeworkTopic> homeworkTopics = new HashSet<HomeworkTopic>(0);
	private Set<TC> TCs = new HashSet<TC>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Department department, Timestamp RDate, String password,
			Boolean sex, Boolean state, Integer type, String username) {
		this.department = department;
		this.RDate = RDate;
		this.password = password;
		this.sex = sex;
		this.state = state;
		this.type = type;
		this.username = username;
	}

	/** full constructor */
	public User(Department department, Timestamp RDate, String email,
			String password, Boolean sex, Boolean state, Long tel,
			Integer type, String username, Set<TestAnswer> testAnswers,
			Set<Resource> resources, Set<TestTopic> testTopics,
			Set<ExercisesAnswer> exercisesAnswers,
			Set<ExercisesTopic> exercisesTopics,
			Set<HomeworkAnswer> homeworkAnswers,
			Set<HomeworkTopic> homeworkTopics, Set<TC> TCs) {
		this.department = department;
		this.RDate = RDate;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.state = state;
		this.tel = tel;
		this.type = type;
		this.username = username;
		this.testAnswers = testAnswers;
		this.resources = resources;
		this.testTopics = testTopics;
		this.exercisesAnswers = exercisesAnswers;
		this.exercisesTopics = exercisesTopics;
		this.homeworkAnswers = homeworkAnswers;
		this.homeworkTopics = homeworkTopics;
		this.TCs = TCs;
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

	@Column(name = "r_date", nullable = false, length = 0)
	public Timestamp getRDate() {
		return this.RDate;
	}

	public void setRDate(Timestamp RDate) {
		this.RDate = RDate;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex", nullable = false)
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "state", nullable = false)
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Column(name = "tel")
	public Long getTel() {
		return this.tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<TestAnswer> getTestAnswers() {
		return this.testAnswers;
	}

	public void setTestAnswers(Set<TestAnswer> testAnswers) {
		this.testAnswers = testAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<TestTopic> getTestTopics() {
		return this.testTopics;
	}

	public void setTestTopics(Set<TestTopic> testTopics) {
		this.testTopics = testTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ExercisesAnswer> getExercisesAnswers() {
		return this.exercisesAnswers;
	}

	public void setExercisesAnswers(Set<ExercisesAnswer> exercisesAnswers) {
		this.exercisesAnswers = exercisesAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ExercisesTopic> getExercisesTopics() {
		return this.exercisesTopics;
	}

	public void setExercisesTopics(Set<ExercisesTopic> exercisesTopics) {
		this.exercisesTopics = exercisesTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<HomeworkAnswer> getHomeworkAnswers() {
		return this.homeworkAnswers;
	}

	public void setHomeworkAnswers(Set<HomeworkAnswer> homeworkAnswers) {
		this.homeworkAnswers = homeworkAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<HomeworkTopic> getHomeworkTopics() {
		return this.homeworkTopics;
	}

	public void setHomeworkTopics(Set<HomeworkTopic> homeworkTopics) {
		this.homeworkTopics = homeworkTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<TC> getTCs() {
		return this.TCs;
	}

	public void setTCs(Set<TC> TCs) {
		this.TCs = TCs;
	}

}