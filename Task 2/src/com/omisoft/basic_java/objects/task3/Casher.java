package com.omisoft.basic_java.objects.task3;


/**
 * Creates class Casher witch extends Staff
 * @author bkoprinski
 *
 */
public class Casher extends Staff{
	private int cashNumber;
	private String email;
	
	public Casher(String identNumber,int count) {
		super(identNumber,count);
		// TODO Auto-generated constructor stub
	}

	public int getCashNumber() {
		return cashNumber;
	}

	public void setCashNumber(int cashnumber) {
		cashNumber = cashnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
