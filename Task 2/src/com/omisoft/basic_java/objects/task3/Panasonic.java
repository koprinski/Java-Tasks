package com.omisoft.basic_java.objects.task3;
/**
 * Creates class Panasonic which extends TvSets
 * @author bkoprinski
 *
 */
public class Panasonic extends TvSets {
	private String internetConnection;
	private String convert;
	
	public Panasonic(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getConv() {
		return convert;
	}

	public void setConv(String conv) {
		convert = conv;
	}

	public String getInternetConnection() {
		return internetConnection;
	}

	public void setInternetConnection(String internetconnection) {
		internetConnection = internetconnection;
	}

}
