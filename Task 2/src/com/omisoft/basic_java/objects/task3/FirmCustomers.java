package com.omisoft.basic_java.objects.task3;


/**
 * Creates class FirmCustomers which extends Customers
 * @author bkoprinski
 *
 */
public class FirmCustomers extends Customers {
	private int bulN;
	private int EGN;
	public FirmCustomers(String identNumber,int count) {
		super(identNumber,count);
		// TODO Auto-generated constructor stub
	}
	public int getBul() {
		return bulN;
	}
	public void setBul(int bul) {
		bulN = bul;
	}
	public int getEGN() {
		return EGN;
	}
	public void setEGN(int eGN) {
		EGN = eGN;
	}
	
}
