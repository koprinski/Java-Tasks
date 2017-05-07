package com.omisoft.basic_java.objects.task3;
/**
 * Creates class Gibson which extends guitars
 * @author bkoprinski
 *
 */
public class Gibson extends Guitars {
	private String bodyType;
	private String gName;
	
	public Gibson(String identNumber, int count) {
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
