package com.marsh.weather.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherEntry implements Serializable {

	private Instant timestamp;

	private double tempMin;
	private double tempMax;

	@JsonProperty("timestamp")
	  public Instant getTimestamp() {
		  return this.timestamp;
	}
	  
	  @JsonSetter("dt") 
	  public void setTimestamp(Instant timeStamp) { 
		  this.timestamp = timeStamp; 
		  
	  }
	 
	/*
	 * @JsonSetter("dt") public void setTimestamp(long unixTime) { this.timestamp =
	 * Instant.ofEpochMilli(unixTime * 1000);
	 * 
	 * }
	 */
	 

	public double getTempMin() {
		return tempMin;
	}

	/*
	 * @JsonProperty("timestamp") public String getTimestamp() { return timestamp; }
	 * 
	 * @JsonSetter("dt_txt") public void setTimestamp(String timestamp) {
	 * this.timestamp = timestamp; }
	 */

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTempMin(Double.parseDouble(main.get("temp_min").toString()));
		setTempMax(Double.parseDouble(main.get("temp_max").toString()));
	}

}
