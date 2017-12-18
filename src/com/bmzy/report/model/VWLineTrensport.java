package com.bmzy.report.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "interface.VW_LINE_TRANSPORT")
public class VWLineTrensport {
	@Id
	@Column(name = "LINEID")
	private int lineid;
	@Id
	@Column(name = "TRANSCODE")
	private String transcode;
	@Id
	@Column(name = "TRANSD")
	private String transd;
	@Id
	@Column(name = "Times")
	private String times;
	@Column(name = "NUM")
	private int num;
	@Column(name = "TRANSPORT")
	private int transport;
	public int getLineid() {
		return lineid;
	}
	public void setLineid(int lineid) {
		this.lineid = lineid;
	}
	public String getTranscode() {
		return transcode;
	}
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	public String getTransd() {
		return transd;
	}
	public void setTransd(String transd) {
		this.transd = transd;
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
	public int getTransport() {
		return transport;
	}
	public void setTransport(int transport) {
		this.transport = transport;
	}
	
	
}
