package com.sk.prj.dto;

public class RunVotingHistoryDTO {
	private String vaid;
	private String id;
	private String bvoteacnt;
	private String voteflag;
	private String createdtm;
	
	public String getVaid() {
		return vaid;
	}
	public void setVaid(String vaid) {
		this.vaid = vaid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBvoteacnt() {
		return bvoteacnt;
	}
	public void setBvoteacnt(String bvoteacnt) {
		this.bvoteacnt = bvoteacnt;
	}
	public String getVoteflag() {
		return voteflag;
	}
	public void setVoteflag(String voteflag) {
		this.voteflag = voteflag;
	}
	public String getCreatedtm() {
		return createdtm;
	}
	public void setCreatedtm(String createdtm) {
		this.createdtm = createdtm;
	}

}
