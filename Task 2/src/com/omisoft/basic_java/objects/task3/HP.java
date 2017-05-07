package com.omisoft.basic_java.objects.task3;
/**
 * Creates class HP which extend laptops
 * @author bkoprinski
 *
 */
public class HP extends Laptops{
	private int yearLaptop;
	private String modelLaptop;
	
	public HP(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public int getYear() {
		return yearLaptop;
	}

	public void setYear(int year) {
		yearLaptop = year;
	}

	public String getModel() {
		return modelLaptop;
	}

	public void setModel(String model) {
		modelLaptop = model;
	}

}
