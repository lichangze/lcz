package com.bmzy.report.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import com.bmzy.report.util.SupperModel;
/**
 * @author July_whj
 *
 *  city        "北京"//城市  
	cityid      "101010100"//城市编码  
	temp        "22"//当前温度  
	WD      "东南风"//风向  
	WS      "3级"//风速 
	SD      "31%"//相对湿度  
	WSE         "3"//风力  
	time        "20:15"//更新时间  
	isRadar "1"//是否有雷达图   （1表示有雷达图）
	Radar   "JC_RADAR_AZ9010_JB"//雷达图地址（AZ9010为北京雷达）
 */
@Table(name = "WEATHER")
public class WeatherEntity  {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "Radar")
	private String radar;
	@Column(name = "SD")
	private String sd;
	@Column(name = "WD")
	private String wd;
	@Column(name = "WS")
	private String ws;
	@Column(name = "WSE")
	private String wse;
	@Column(name = "city")
	private String city;
	@Column(name = "temp")
	private String temp;
	@Column(name = "wtime")
	private String time;
	@Column(name = "wdate")
	private Date date;
	public String getRadar() {
		return radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}

	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getWse() {
		return wse;
	}

	public void setWse(String wse) {
		this.wse = wse;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	} 
	
}
