package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="qdzd.OD_VehicleServiceUsage")
public class VehicleServiceUsageEntity {
	@Id
	@Column(name="VehicleServiceUsageID")
	private String VehicleServiceUsageID;
	@Column(name="LineID")
	private String LineID;
	@Column(name="RecordDate")
	private Date RecordDate;
	@Column(name="PlanRunNum")
	private int PlanRunNum;
	@Column(name="RealRunNum")
	private int RealRunNum;
	@Column(name="AddRunNum")
	private int AddRunNum;
	@Column(name="FulfillmentPT")
	private String FulfillmentPT;
	@Column(name="PunctualityPT")
	private String PunctualityPT;
	@Column(name="PlanMileage")
	private String PlanMileage;
	@Column(name="RealMileage")
	private String RealMileage;
	@Column(name="PlanUsedVehicleNumber")
	private int PlanUsedVehicleNumber;
	@Column(name="PlanStandByVehicleNumber")
	private int PlanStandByVehicleNumber;
	@Column(name="UsedVehicleNumber")
	private int UsedVehicleNumber;
	@Column(name="StandByVehicleNumber")
	private int  StandByVehicleNumber;
	@Column(name="TestVehicleNumber")
	private int TestVehicleNumber;
	@Column(name="ExamVehicleNumber")
	private int ExamVehicleNumber;
	@Column(name="OtherVehicleNumber")
	private int OtherVehicleNumber;
	@Column(name="TotalVehicleNumber")
	private int TotalVehicleNumber;
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
	@Column(name="MaxInterval")
	private String MaxInterval;
	@Column(name="MaxIntervalSecond")
	private int MaxIntervalSecond;
	public String getVehicleServiceUsageID() {
		return VehicleServiceUsageID;
	}
	public void setVehicleServiceUsageID(String vehicleServiceUsageID) {
		VehicleServiceUsageID = vehicleServiceUsageID;
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
	public int getPlanRunNum() {
		return PlanRunNum;
	}
	public void setPlanRunNum(int planRunNum) {
		PlanRunNum = planRunNum;
	}
	public int getRealRunNum() {
		return RealRunNum;
	}
	public void setRealRunNum(int realRunNum) {
		RealRunNum = realRunNum;
	}
	public int getAddRunNum() {
		return AddRunNum;
	}
	public void setAddRunNum(int addRunNum) {
		AddRunNum = addRunNum;
	}
	public String getFulfillmentPT() {
		return FulfillmentPT;
	}
	public void setFulfillmentPT(String fulfillmentPT) {
		FulfillmentPT = fulfillmentPT;
	}
	public String getPunctualityPT() {
		return PunctualityPT;
	}
	public void setPunctualityPT(String punctualityPT) {
		PunctualityPT = punctualityPT;
	}
	public String getPlanMileage() {
		return PlanMileage;
	}
	public void setPlanMileage(String planMileage) {
		PlanMileage = planMileage;
	}
	public String getRealMileage() {
		return RealMileage;
	}
	public void setRealMileage(String realMileage) {
		RealMileage = realMileage;
	}
	public int getPlanUsedVehicleNumber() {
		return PlanUsedVehicleNumber;
	}
	public void setPlanUsedVehicleNumber(int planUsedVehicleNumber) {
		PlanUsedVehicleNumber = planUsedVehicleNumber;
	}
	public int getPlanStandByVehicleNumber() {
		return PlanStandByVehicleNumber;
	}
	public void setPlanStandByVehicleNumber(int planStandByVehicleNumber) {
		PlanStandByVehicleNumber = planStandByVehicleNumber;
	}
	public int getUsedVehicleNumber() {
		return UsedVehicleNumber;
	}
	public void setUsedVehicleNumber(int usedVehicleNumber) {
		UsedVehicleNumber = usedVehicleNumber;
	}
	public int getStandByVehicleNumber() {
		return StandByVehicleNumber;
	}
	public void setStandByVehicleNumber(int standByVehicleNumber) {
		StandByVehicleNumber = standByVehicleNumber;
	}
	public int getTestVehicleNumber() {
		return TestVehicleNumber;
	}
	public void setTestVehicleNumber(int testVehicleNumber) {
		TestVehicleNumber = testVehicleNumber;
	}
	public int getExamVehicleNumber() {
		return ExamVehicleNumber;
	}
	public void setExamVehicleNumber(int examVehicleNumber) {
		ExamVehicleNumber = examVehicleNumber;
	}
	public int getOtherVehicleNumber() {
		return OtherVehicleNumber;
	}
	public void setOtherVehicleNumber(int otherVehicleNumber) {
		OtherVehicleNumber = otherVehicleNumber;
	}
	public int getTotalVehicleNumber() {
		return TotalVehicleNumber;
	}
	public void setTotalVehicleNumber(int totalVehicleNumber) {
		TotalVehicleNumber = totalVehicleNumber;
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
	public String getMaxInterval() {
		return MaxInterval;
	}
	public void setMaxInterval(String maxInterval) {
		MaxInterval = maxInterval;
	}
	public int getMaxIntervalSecond() {
		return MaxIntervalSecond;
	}
	public void setMaxIntervalSecond(int maxIntervalSecond) {
		MaxIntervalSecond = maxIntervalSecond;
	}
}
