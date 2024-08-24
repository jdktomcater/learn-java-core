package com.jdktomcat.pack.dsa.algorithm.introduction.base;

public class DataWrapper {
	
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	

	public DataWrapper(Integer value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return value + "";
	}
}
