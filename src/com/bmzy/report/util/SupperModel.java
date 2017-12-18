package com.bmzy.report.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

public class SupperModel {
	public static final String CREATED_TIME = "createdTime";
	public static final String LAST_MODIFIED_TIME = "lastModifidTime";
	public static final String INVALID="invalid";
	public static final String VERSION="version";
	
	@Id
	@GeneratedValue(generator = "UUID")
	private String id;
	
	@Version
	@Column(name = "version")
	private int version;
	
	@Column(name = "createdTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdTime;
	@Column(name = "lastModifidTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lastModifidTime;
	@Column(name = "userId")
	private String userId;
	@Column
	private boolean invalid = false;//false时有效；true时无效
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getLastModifidTime() {
		return lastModifidTime;
	}
	public void setLastModifidTime(Date lastModifidTime) {
		this.lastModifidTime = lastModifidTime;
	}
	public boolean isInvalid() {
		return invalid;
	}
	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
 
