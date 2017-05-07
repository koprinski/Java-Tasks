package com.omisoft.basic_java.objects.task3;


/**
 * Creates class Dell which extends Laptops and implements
 * the functions from the interface Guarantee
 * @author bkoprinski
 *
 */
public class Dell extends Laptops implements Guarantee{
	private int yearLaptop;
	private String modelLaptop;
	
	public Dell(String identNumber, int count) {
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
	/**
	 * Function that prints when the guarantee expires
	 */
	public void expires()
	{
		System.out.println("The guarantee expires in 3 years!");
	}
	/**
	 * Function that prints what will happen if the laptop is broken
	 */
	public void broken()
	{
		System.out.println("If the laptop is broken you will get a new one!");
	}

}
