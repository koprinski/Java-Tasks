package com.omisoft.basic_java.objects.task3;


/**
 * Creates class Manager which extends Staff
 * @author bkoprinski
 *
 */
public class Manager extends Staff {
	private String shift;
	private int age;
	
	public Manager(String identNumber,int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
