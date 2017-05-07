package com.omisoft.basic_java.objects.task3;
/**
 * Creates class Laptops which extends Products
 * @author bkoprinski
 *
 */
public class Laptops extends Products {
	private int discSpace;
	private int lVideo;
	
	public Laptops(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}
	
	public int getDiscSpace() {
		return discSpace;
	}

	public void setDiscSpace(int discspace) {
		discSpace = discspace;
	}

	public int getVideo() {
		return lVideo;
	}

	public void setVideo(int video) {
		lVideo = video;
	}

}
