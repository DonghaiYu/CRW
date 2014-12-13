package com.crw.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resource", catalog = "crw_data")
public class Resource implements java.io.Serializable ,Comparable<Resource>{

	// Fields

	private Long id;
	private User user;
	private Course course;
	private Long DTimes;
	private Timestamp date;
	private String name;
	private String path;
	private String type;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** full constructor */
	public Resource(User user, Course course, Long DTimes, Timestamp date,
			String name, String path, String type) {
		this.user = user;
		this.course = course;
		this.DTimes = DTimes;
		this.date = date;
		this.name = name;
		this.path = path;
		this.type = type;
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

	@Column(name = "d_times", nullable = false)
	public Long getDTimes() {
		return this.DTimes;
	}

	public void setDTimes(Long DTimes) {
		this.DTimes = DTimes;
	}

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "path", nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int compareTo(Resource o) {
		return this.getDate().compareTo(o.getDate());
	}

}