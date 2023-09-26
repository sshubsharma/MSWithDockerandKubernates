package com.shubham.microservices.limitservice.dto;

public class LimitDTO {
	
	private int maxLimit;
	private int minLimit;
	
	public LimitDTO() {
		super();
	}
	
	public LimitDTO(int maxLimit, int minLimit) {
		super();
		this.maxLimit = maxLimit;
		this.minLimit = minLimit;
	}
	public int getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	public int getMinLimit() {
		return minLimit;
	}
	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}
	
	

}
