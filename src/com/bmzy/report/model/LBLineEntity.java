package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="qdzd.LB_Line")
public class LBLineEntity {
	@Id
	@Column(name="LineID")
	private String LineID;
	@Column(name="LineName")
	private String LineName;
	@Column(name="SimpleName")
	private String SimpleName;
	@Column(name="EngName")
	private String EngName;
	@Column(name="DisplayName")
	private String DisplayName;
	@Column(name="SortOrder")
	private int SortOrder;
	@Column(name="LineKind")
	private int LineKind;
	@Column(name="ServiceState")
	private int ServiceState;
	@Column(name="MinInterval")
	private int MinInterval;
	@Column(name="MaxInterval")
	private int MaxInterval;
	@Column(name="OpLength")
	private int OpLength;
	@Column(name="CoachNum")
	private int CoachNum;
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
	@Column(name="SyncTime")
	private Date SyncTime;
	public String getLineID() {
		return LineID;
	}
	public void setLineID(String lineID) {
		LineID = lineID;
	}
	public String getLineName() {
		return LineName;
	}
	public void setLineName(String lineName) {
		LineName = lineName;
	}
	public String getSimpleName() {
		return SimpleName;
	}
	public void setSimpleName(String simpleName) {
		SimpleName = simpleName;
	}
	public String getEngName() {
		return EngName;
	}
	public void setEngName(String engName) {
		EngName = engName;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public int getSortOrder() {
		return SortOrder;
	}
	public void setSortOrder(int sortOrder) {
		SortOrder = sortOrder;
	}
	public int getLineKind() {
		return LineKind;
	}
	public void setLineKind(int lineKind) {
		LineKind = lineKind;
	}
	public int getServiceState() {
		return ServiceState;
	}
	public void setServiceState(int serviceState) {
		ServiceState = serviceState;
	}
	public int getMinInterval() {
		return MinInterval;
	}
	public void setMinInterval(int minInterval) {
		MinInterval = minInterval;
	}
	public int getMaxInterval() {
		return MaxInterval;
	}
	public void setMaxInterval(int maxInterval) {
		MaxInterval = maxInterval;
	}
	public int getOpLength() {
		return OpLength;
	}
	public void setOpLength(int opLength) {
		OpLength = opLength;
	}
	public int getCoachNum() {
		return CoachNum;
	}
	public void setCoachNum(int coachNum) {
		CoachNum = coachNum;
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
	public Date getSyncTime() {
		return SyncTime;
	}
	public void setSyncTime(Date syncTime) {
		SyncTime = syncTime;
	}
}
