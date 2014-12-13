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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "department", catalog = "crw_data")
public class Department implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Integer studentSum;
	private Integer teacherSum;
	private Set<User> users = new HashSet<User>(0);
	private Set<Course> courses = new HashSet<Course>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String name, Integer studentSum, Integer teacherSum) {
		this.name = name;
		this.studentSum = studentSum;
		this.teacherSum = teacherSum;
	}

	/** full constructor */
	public Department(String name, Integer studentSum, Integer teacherSum,
			Set<User> users, Set<Course> courses) {
		this.name = name;
		this.studentSum = studentSum;
		this.teacherSum = teacherSum;
		this.users = users;
		this.courses = courses;
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

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "student_sum", nullable = false)
	public Integer getStudentSum() {
		return this.studentSum;
	}

	public void setStudentSum(Integer studentSum) {
		this.studentSum = studentSum;
	}

	@Column(name = "teacher_sum", nullable = false)
	public Integer getTeacherSum() {
		return this.teacherSum;
	}

	public void setTeacherSum(Integer teacherSum) {
		this.teacherSum = teacherSum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}