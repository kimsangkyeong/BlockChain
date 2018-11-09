package com.sk.prj.dto;

public class ReservationDTO {
	private String name;
	private String discription;
	private String use_id;
	private String use_yn;
	
	public String getName() {
		return name;
	}
	public String getDiscription() {
		return discription;
	}
	public String getUse_id() {
		return use_id;
	}
	public String getUse_yn() {
		return use_yn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setUse_id(String use_id) {
		this.use_id = use_id;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
}

