package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="OD_PassengerNumber")
public class PassengerNumberEntity {
	@Id
	@Column(name="PassengerNumberID")
	private String PassengerNumberID;
	@Column(name="LineID")
	private String LineID;
	@Column(name="PointID")
	private String PointID;
	@Column(name="RecordDate")
	private Date RecordDate;
	@Column(name="EnterStationNum")
	private int EnterStationNum;
	@Column(name="OutStationNum")
	private int OutStationNum;
	@Column(name="BuyTicketNum")
	private int BuyTicketNum;
	@Column(name="RechargeNum")
	private int RechargeNum;
	@Column(name="TransferNumber")
	private int TransferNumber;
	@Column(name="SideDoorNum")
	private int SideDoorNum;
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
	@Column(name="SideDoorOutNum")
	private int SideDoorOutNum;
	public String getPassengerNumberID() {
		return PassengerNumberID;
	}
	public void setPassengerNumberID(String passengerNumberID) {
		PassengerNumberID = passengerNumberID;
	}
	public String getLineID() {
		return LineID;
	}
	public void setLineID(String lineID) {
		LineID = lineID;
	}
	public String getPointID() {
		return PointID;
	}
	public void setPointID(String pointID) {
		PointID = pointID;
	}
	public Date getRecordDate() {
		return RecordDate;
	}
	public void setRecordDate(Date recordDate) {
		RecordDate = recordDate;
	}
	public int getEnterStationNum() {
		return EnterStationNum;
	}
	public void setEnterStationNum(int enterStationNum) {
		EnterStationNum = enterStationNum;
	}
	public int getOutStationNum() {
		return OutStationNum;
	}
	public void setOutStationNum(int outStationNum) {
		OutStationNum = outStationNum;
	}
	public int getBuyTicketNum() {
		return BuyTicketNum;
	}
	public void setBuyTicketNum(int buyTicketNum) {
		BuyTicketNum = buyTicketNum;
	}
	public int getRechargeNum() {
		return RechargeNum;
	}
	public void setRechargeNum(int rechargeNum) {
		RechargeNum = rechargeNum;
	}
	public int getTransferNumber() {
		return TransferNumber;
	}
	public void setTransferNumber(int transferNumber) {
		TransferNumber = transferNumber;
	}
	public int getSideDoorNum() {
		return SideDoorNum;
	}
	public void setSideDoorNum(int sideDoorNum) {
		SideDoorNum = sideDoorNum;
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
	public int getSideDoorOutNum() {
		return SideDoorOutNum;
	}
	public void setSideDoorOutNum(int sideDoorOutNum) {
		SideDoorOutNum = sideDoorOutNum;
	}
}