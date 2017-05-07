package com.omisoft.basic_java.objects.task3;
/**
 * Creates class Samsung which extends TvSets
 * @author bkoprinski
 *
 */
public class Samsung extends TvSets {
	private String internetConnection;
	private String convert;
	
	public Samsung(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getInternetConnection() {
		return internetConnection;
	}

	public void setInternetConnection(String internetConnection) {
		this.internetConnection = internetConnection;
	}

	public String getConvert() {
		return convert;
	}

	public void setConvert(String convert) {
		this.convert = convert;
	}

}
