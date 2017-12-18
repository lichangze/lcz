package com.bmzy.report.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "interface.VW_LINE")
public class VWLineEntity {
	
	@Column(name = "LINENAME")
	private String lineName;
	
	@Id
	@Column(name = "LINEID")
	private int lineId;

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	
	
}
