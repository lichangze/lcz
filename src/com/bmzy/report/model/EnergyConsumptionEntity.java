package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="qdzd.OD_EnergyConsumption")
public class EnergyConsumptionEntity {
	@Id
	@Column(name="EnergyConsumptionID")
	private String EnergyConsumptionID;
	@Column(name="LineID")
	private String LineID;
	@Column(name="RecordDate")
	private Date RecordDate;
	@Column(name="ConsumptionTraction")
	private int ConsumptionTraction;
	@Column(name="ConsumptionPowerLighting")
	private int ConsumptionPowerLighting;
	@Column(name="ConsumptionTotal")
	private int ConsumptionTotal;
	@Column(name="ConsumptionOther")
	private int ConsumptionOther;
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
	public String getEnergyConsumptionID() {
		return EnergyConsumptionID;
	}
	public void setEnergyConsumptionID(String energyConsumptionID) {
		EnergyConsumptionID = energyConsumptionID;
	}
	public String getLineID() {
		return LineID;
	}
	public void setLineID(String lineID) {
		LineID = lineID;
	}
	public Date getRecordDate() {
		return RecordDate;
	}
	public void setRecordDate(Date recordDate) {
		RecordDate = recordDate;
	}
	public int getConsumptionTraction() {
		return ConsumptionTraction;
	}
	public void setConsumptionTraction(int consumptionTraction) {
		ConsumptionTraction = consumptionTraction;
	}
	public int getConsumptionPowerLighting() {
		return ConsumptionPowerLighting;
	}
	public void setConsumptionPowerLighting(int consumptionPowerLighting) {
		ConsumptionPowerLighting = consumptionPowerLighting;
	}
	public int getConsumptionTotal() {
		return ConsumptionTotal;
	}
	public void setConsumptionTotal(int consumptionTotal) {
		ConsumptionTotal = consumptionTotal;
	}
	public int getConsumptionOther() {
		return ConsumptionOther;
	}
	public void setConsumptionOther(int consumptionOther) {
		ConsumptionOther = consumptionOther;
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
	
}
