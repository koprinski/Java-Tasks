package com.omisoft.basic_java.objects.task3;
/**
 * Creates class Guitars which extends products
 * @author bkoprinski
 *
 */
public class Guitars extends Products {
	private int stringNum;
	private String gType;
	
	public Guitars(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public int getStringNum() {
		return stringNum;
	}

	public void setStringNum(int stringnum) {
		stringNum = stringnum;
	}

	public String getModel() {
		return gType;
	}

	public void setModel(String model) {
		gType = model;
	}

}
