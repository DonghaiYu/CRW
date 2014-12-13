package com.crw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TC entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_c", catalog = "crw_data")
public class TC implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private Course course;

	// Constructors

	/** default constructor */
	public TC() {
	}

	/** full constructor */
	public TC(Long id, User user, Course course) {
		this.id = id;
		this.user = user;
		this.course = course;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}