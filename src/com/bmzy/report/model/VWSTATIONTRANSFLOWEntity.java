package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "interface.VW_STATION_TRANSFLOW")
public class VWSTATIONTRANSFLOWEntity {
	@Column(name = "STATIONID")
	private int stationId;
	@Column(name = "CDATE")
	private Date cDate;
	@Column(name = "LINEID1")
	private int lineId1;
	@Column(name = "TRANSD1")
	private int transd1;
	@Column(name = "LINEID2")
	private int lineId2;
	@Column(name = "TRANSD2")
	private int transd2;
	@Column(name = "DATATYPE")
	private int dataType;
	@Column(name = "TIMES")
	private String times;
	@Column(name = "NUM")
	private int num;
	@Column(name = "TOTAL")
	private int total;
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public int getLineId1() {
		return lineId1;
	}
	public void setLineId1(int lineId1) {
		this.lineId1 = lineId1;
	}
	public int getTransd1() {
		return transd1;
	}
	public void setTransd1(int transd1) {
		this.transd1 = transd1;
	}
	public int getLineId2() {
		return lineId2;
	}
	public void setLineId2(int lineId2) {
		this.lineId2 = lineId2;
	}
	public int getTransd2() {
		return transd2;
	}
	public void setTransd2(int transd2) {
		this.transd2 = transd2;
	}
	public int getDataType() {
		return dataType;
	}
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	
}
