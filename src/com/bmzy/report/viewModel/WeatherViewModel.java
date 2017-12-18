package com.bmzy.report.viewModel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherViewModel {
	@JsonProperty("weatherinfo")
	private WeatherModel weatherinfo;

	public WeatherModel getWeatherinfo() {
		return weatherinfo;
	}

	public void setWeatherinfo(WeatherModel weatherinfo) {
		this.weatherinfo = weatherinfo;
	}
	
	
}
