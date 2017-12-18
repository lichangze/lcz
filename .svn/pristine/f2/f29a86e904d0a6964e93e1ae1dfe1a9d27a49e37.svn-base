package com.bmzy.report.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "EAM_POS_POSITION")
public class EamPositonEntity {

	/**
	 * 车站编号
	 */
	@Id
	@Column(name = "POSITION_NO")
	private String position_no;
	/**
	 * 车站编码
	 */
	@Column(name = "POSITION_CODE")
	private String position_code;
	/**
	 * 父位置编码
	 */
	@Column(name = "F_POSITION_NO")
	private String f_position_no;
	/**
	 * 车站名称
	 */
	@Column(name = "POSITION_NAME")
	private String position_name;
	/**
	 * 所属线路
	 */
	@Column(name = "LINE_CODE")
	private String line_code;
	/**
	 * 经度
	 */
	@Column(name = "LONGITUDE")
	private float longitude;
	/**
	 * 纬度
	 */
	@Column(name = "LATITUDE")
	private float latitude;
	/**
	 * 部门编码
	 */
	@Column(name = "DEPT_NO")
	private String dept_no;
	/**
	 * 所属部门
	 */
	@Column(name = "BELONG_DEPT")
	private String belong_dept;
	/**
	 * 创建时间
	 */
	@Column(name = "createdTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp createdTime;
	/**
	 * 最后修改时间
	 */
	@Column(name = "lastModifidTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp lastModifidTime;
	/**
	 * 备注
	 */
	@Column(name = "MEMO")
	private String memo;

	public String getPosition_no() {
		return position_no;
	}

	public void setPosition_no(String position_no) {
		this.position_no = position_no;
	}

	public String getPosition_code() {
		return position_code;
	}

	public void setPosition_code(String position_code) {
		this.position_code = position_code;
	}

	public String getF_position_no() {
		return f_position_no;
	}

	public void setF_position_no(String f_position_no) {
		this.f_position_no = f_position_no;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getPosLine() {
		return line_code;
	}

	public void setPosLine(String line_code) {
		this.line_code = line_code;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getLine_code() {
		return line_code;
	}

	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}

	public String getBelong_dept() {
		return belong_dept;
	}

	public void setBelong_dept(String belong_dept) {
		this.belong_dept = belong_dept;
	}

	
	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getLastModifidTime() {
		return lastModifidTime;
	}

	public void setLastModifidTime(Timestamp lastModifidTime) {
		this.lastModifidTime = lastModifidTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}