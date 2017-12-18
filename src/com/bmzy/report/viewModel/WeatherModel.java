package com.bmzy.report.viewModel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel {
	@JsonProperty("Radar")
	private String Radar;
	@JsonProperty("SD")
	private String SD;
	@JsonProperty("WD")
	private String WD;
	@JsonProperty("WS")
	private String WS;
	@JsonProperty("WSE")
	private String WSE;
	@JsonProperty("city")
	private String city;
	@JsonProperty("temp")
	private String temp;
	@JsonProperty("time")
	private String time;
	public String getRadar() {
		return Radar;
	}
	public void setRadar(String radar) {
		Radar = radar;
	}
	public String getSD() {
		return SD;
	}
	public void setSD(String sD) {
		SD = sD;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	public String getWS() {
		return WS;
	}
	public void setWS(String wS) {
		WS = wS;
	}
	public String getWSE() {
		return WSE;
	}
	public void setWSE(String wSE) {
		WSE = wSE;
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
	
}
