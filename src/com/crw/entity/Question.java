package com.crw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question", catalog = "crw_data")
public class Question implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private long stuId;
	private String text;
	private int tecId;
	private Date time;
	private int status;
	private int flag; //1代表建议 0代表问题
	private String reply;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "name", nullable = false, length = 0)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "stu_id", nullable = false)
    public long getStuId() {
		return stuId;
	}
	public void setStuId(long id) {
		this.stuId = id;
	}
	
	@Column(name = "time", nullable = false)
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Column(name = "tec_id", nullable = false)
	public int getTecId() {
		return tecId;
	}
	public void setTecId(int tecId) {
		this.tecId = tecId;
	}
	@Column(name = "status", nullable = false)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "flag", nullable = false)
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Column(name = "reply")
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	@Column(name = "text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	

}
