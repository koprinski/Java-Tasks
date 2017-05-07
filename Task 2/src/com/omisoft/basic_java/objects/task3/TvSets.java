package com.omisoft.basic_java.objects.task3;
/**
 * Creates class TvSets which extends products
 * @author bkoprinski
 *
 */
public class TvSets extends Products {
	private int screenSize;
	private int tvResolution;
	
	public TvSets(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screensize) {
		screenSize = screensize;
	}

	public int getResolution() {
		return tvResolution;
	}

	public void setResolution(int resolution) {
		tvResolution = resolution;
	}

}
