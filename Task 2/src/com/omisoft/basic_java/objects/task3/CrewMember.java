package com.omisoft.basic_java.objects.task3;


/**
 * Creates class CrewMember which extends Staff
 * @author bkoprinski
 *
 */
public class CrewMember extends Staff {
	private String dutyCM;
	private String telNumber;
	
	public CrewMember(String identNumber,int count) {
		super(identNumber, count);

	}

	public String getDuty() {
		System.out.println(dutyCM);
		return dutyCM;
	}

	public void setDuty(String duty) {
		dutyCM = duty;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
}
