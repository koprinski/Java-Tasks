package com.omisoft.basic_java.objects.task3;


/**
 * Creates class Cleaner which extends Staff
 * @author bkoprinski
 *
 */
public class Cleaner extends Staff {
	private String region;
	private int week;
	
	public Cleaner(String identNumber,int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

}
