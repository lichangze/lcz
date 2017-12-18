package com.bmzy.report.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "interface.ZD_PASSENGERQUANTITY")
public class PassEngerQuantityEntity {
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "LINEID")
	private String lineId;
	@Column(name = "CDATE")
	private Date cDate; 
	@Column(name = "PASVALUE")
	private int  pasValue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public int getPasValue() {
		return pasValue;
	}
	public void setPasValue(int pasValue) {
		this.pasValue = pasValue;
	}
	
	
}
