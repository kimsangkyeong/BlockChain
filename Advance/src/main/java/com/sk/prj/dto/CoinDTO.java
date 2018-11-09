package com.sk.prj.dto;

public class CoinDTO {
	private String from_id;
	private String to_id;
	private int value;
	private String dateTime;
	
	private String from_name;
	private String to_name;

	public String getFrom_id() {
		return from_id;
	}
	public String getTo_id() {
		return to_id;
	}
	public int getValue() {
		return value;
	}
	public String getDateTime() {
		return dateTime;
	}
	
	public String getFrom_name() {
		return from_name;
	}
	public String getTo_name() {
		return to_name;
	}
	
	
	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}
	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
