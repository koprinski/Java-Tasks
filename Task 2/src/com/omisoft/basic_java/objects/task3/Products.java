package com.omisoft.basic_java.objects.task3;

/**
 * Creates class Products which extends store
 * @author bkoprinski
 *
 */
public class Products extends Store {
	private String serialNumber;
	private int prTag;
	
	public Products(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getSpecifications() {
		return serialNumber;
	}

	public void setSpecifications(String specifications) {
		serialNumber = specifications;
	}

	public int getPrTag() {
		return prTag;
	}

	public void setPrTag(int prtag) {
		prTag = prtag;
	}
}
