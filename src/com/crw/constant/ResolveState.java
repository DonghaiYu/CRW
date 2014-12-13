package com.crw.constant;

public enum ResolveState {
	UNSOLVE(0,"未解决"),RESOLVED(1,"已解决");
	private int code;
	private String mean;
	
	
	private ResolveState(int code, String mean) {
		this.code = code;
		this.mean = mean;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	
	
	

}
