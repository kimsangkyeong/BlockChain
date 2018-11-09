package com.sk.prj.dto;

public class BallotItemsDTO {
	private String ballotid;
	private String seq;
	private String item;
	private String bcandidate;
	private String regdtm;

	public String getBallotid() {
		return ballotid;
	}
	public void setBallotid(String ballotid) {
		this.ballotid = ballotid;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getBcandidate() {
		return bcandidate;
	}
	public void setBcandidate(String bcandidate) {
		this.bcandidate = bcandidate;
	}
	public String getRegdtm() {
		return regdtm;
	}
	public void setRegdtm(String regdtm) {
		this.regdtm = regdtm;
	}
	
}
