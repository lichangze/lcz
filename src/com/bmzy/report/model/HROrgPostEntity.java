package com.bmzy.report.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "HR_ORG_POST")
public class HROrgPostEntity {
	@Id
	@Column(name = "POSTNO")
	private String postno;
	@Column(name = "POSTNAME")
	private String postname;
	@Column(name = "POSTNO")
	private String deptno;
	@Column(name = "POSTNO")
	private String postpno;
	@Column(name = "POSTNO")
	private String postid;
	@Column(name = "POSTNO")
	private Timestamp createtime;
	@Column(name = "POSTNO")
	private Timestamp lastupdatetime;
	@Column(name = "POSTNO")
	private String fdeletedstatus;
	public String getPostno() {
		return postno;
	}
	public void setPostno(String postno) {
		this.postno = postno;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getPostpno() {
		return postpno;
	}
	public void setPostpno(String postpno) {
		this.postpno = postpno;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Timestamp lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	public String getFdeletedstatus() {
		return fdeletedstatus;
	}
	public void setFdeletedstatus(String fdeletedstatus) {
		this.fdeletedstatus = fdeletedstatus;
	}

}
