package com.bmzy.report.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "HR_ORG_COMP")
public class HROrgCompEntity {
	@Id
	@Column(name = "COMP_NO")
	private int COMP_NO;
	@Column(name = "COMP_NAME")
	private String COMP_NAME;
	@Column(name = "COMP_SHORT")
	private String COMP_SHORT;
	@Column(name = "COMP_PERSON")
	private String COMP_PERSON;
	@Column(name = "COMP_ESTDATE")
	private Date COMP_ESTDATE;
	@Column(name = "COMP_ADDRESS")
	private String COMP_ADDRESS;
	@Column(name = "MEMO")
	private String MEMO;
	@Column(name = "CREATETIME")
	private Timestamp CREATETIME;
	@Column(name = "LASTUPDATETIME")
	private Timestamp LASTUPDATETIME;
	public int getCOMP_NO() {
		return COMP_NO;
	}
	public void setCOMP_NO(int cOMP_NO) {
		COMP_NO = cOMP_NO;
	}
	public String getCOMP_NAME() {
		return COMP_NAME;
	}
	public void setCOMP_NAME(String cOMP_NAME) {
		COMP_NAME = cOMP_NAME;
	}
	public String getCOMP_SHORT() {
		return COMP_SHORT;
	}
	public void setCOMP_SHORT(String cOMP_SHORT) {
		COMP_SHORT = cOMP_SHORT;
	}
	public String getCOMP_PERSON() {
		return COMP_PERSON;
	}
	public void setCOMP_PERSON(String cOMP_PERSON) {
		COMP_PERSON = cOMP_PERSON;
	}
	public Date getCOMP_ESTDATE() {
		return COMP_ESTDATE;
	}
	public void setCOMP_ESTDATE(Date cOMP_ESTDATE) {
		COMP_ESTDATE = cOMP_ESTDATE;
	}
	public String getCOMP_ADDRESS() {
		return COMP_ADDRESS;
	}
	public void setCOMP_ADDRESS(String cOMP_ADDRESS) {
		COMP_ADDRESS = cOMP_ADDRESS;
	}
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
	public Timestamp getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(Timestamp cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public Timestamp getLASTUPDATETIME() {
		return LASTUPDATETIME;
	}
	public void setLASTUPDATETIME(Timestamp lASTUPDATETIME) {
		LASTUPDATETIME = lASTUPDATETIME;
	}

}
