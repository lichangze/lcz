package com.bmzy.report.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bmzy.report.util.SupperModel;

@Table(name = "EAM_POS_LINE")
public class EamPosLineEntity extends SupperModel{

	/**
	 * 线路编码
	 */
	@Column(name = "LINE_CODE")
	private String line_code;
	/**
	 * 线路名称
	 */
	@Column(name = "LINE_NAME")
	private String line_name;
	/**
	 * 公里数
	 */
	@Column(name = "LINE_M")
	private double line_m;
	/**
	 * 
	 */
	@Column(name = "DICT_NO")
	private String dict_no;
	/**
	 * 线路类型
	 */
	@Column(name = "LINE_TYPE")
	private String line_type;
	/**
	 * 运行日期
	 */
	@Column(name = "LINE_STRART_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date line_strart_date;
	/**
	 * 创建时间
	 */
	@Column(name = "createdTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp createdTime;
	/**
	 * 最后修改时间
	 */
	@Column(name = "lastModifidTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp lastModifidTime;
	/**
	 * 备注
	 */
	@Column(name = "MEMO")
	private String memo;
	
	public String getLine_code() {
		return line_code;
	}

	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}

	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public double getLine_m() {
		return line_m;
	}

	public void setLine_m(double line_m) {
		this.line_m = line_m;
	}

	public String getDict_no() {
		return dict_no;
	}

	public void setDict_no(String dict_no) {
		this.dict_no = dict_no;
	}

	public String getLine_type() {
		return line_type;
	}

	public void setLine_type(String line_type) {
		this.line_type = line_type;
	}

	public Date getLine_strart_date() {
		return line_strart_date;
	}

	public void setLine_strart_date(Date line_strart_date) {
		this.line_strart_date = line_strart_date;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getLastModifidTime() {
		return lastModifidTime;
	}

	public void setLastModifidTime(Timestamp lastModifidTime) {
		this.lastModifidTime = lastModifidTime;
	}

}
