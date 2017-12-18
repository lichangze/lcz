package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="qdzd.OD_OtherSituation")
public class OtherSituationEntity {
	@Id
	@Column(name="OtherSituationID")
	private String OtherSituationID;
	@Column(name="LineID")
	private String LineID;
	@Column(name="EventTime")
	private Date EventTime;
	@Column(name="OtherType")
	private String OtherType;
	
	@Column(name="PointID")
	private String PointID;
	@Column(name="RecordStatus")
	private String RecordStatus;
	@Column(name="CreateTime")
	private Date CreateTime;
	@Column(name="UpdateTime")
	private Date UpdateTime;
	@Column(name="CreateUserID")
	private String CreateUserID;
	@Column(name="UpdateUserID")
	private String UpdateUserID;
	@Column(name="CreateUserName")
	private String CreateUserName;
	@Column(name="UpdateUserName")
	private String UpdateUserName;
	@Column(name="PointName")
	private String PointName;
	@Column(name="CauseFeedback")
	private String CauseFeedback;
	public String getOtherSituationID() {
		return OtherSituationID;
	}
	public void setOtherSituationID(String otherSituationID) {
		OtherSituationID = otherSituationID;
	}
	public String getLineID() {
		return LineID;
	}
	public void setLineID(String lineID) {
		LineID = lineID;
	}
	public Date getEventTime() {
		return EventTime;
	}
	public void setEventTime(Date eventTime) {
		EventTime = eventTime;
	}
	public String getOtherType() {
		return OtherType;
	}
	public void setOtherType(String otherType) {
		OtherType = otherType;
	}
	
	public String getPointID() {
		return PointID;
	}
	public void setPointID(String pointID) {
		PointID = pointID;
	}
	public String getRecordStatus() {
		return RecordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		RecordStatus = recordStatus;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public String getCreateUserID() {
		return CreateUserID;
	}
	public void setCreateUserID(String createUserID) {
		CreateUserID = createUserID;
	}
	public String getUpdateUserID() {
		return UpdateUserID;
	}
	public void setUpdateUserID(String updateUserID) {
		UpdateUserID = updateUserID;
	}
	public String getCreateUserName() {
		return CreateUserName;
	}
	public void setCreateUserName(String createUserName) {
		CreateUserName = createUserName;
	}
	public String getUpdateUserName() {
		return UpdateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		UpdateUserName = updateUserName;
	}
	public String getPointName() {
		return PointName;
	}
	public void setPointName(String pointName) {
		PointName = pointName;
	}
	public String getCauseFeedback() {
		return CauseFeedback;
	}
	public void setCauseFeedback(String causeFeedback) {
		CauseFeedback = causeFeedback;
	}
	
}
