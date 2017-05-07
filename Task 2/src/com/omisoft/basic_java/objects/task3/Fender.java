package com.omisoft.basic_java.objects.task3;
/**
 * Creates class Fender which extends guitar
 * @author bkoprinski
 *
 */
public class Fender extends Guitars{
	private String bodyType;
	private String gName;	
	
	public Fender(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodytype) {
		bodyType = bodytype;
	}

	public String getName() {
		return gName;
	}

	public void setName(String name) {
		gName = name;
	}

}
