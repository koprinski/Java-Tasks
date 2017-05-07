package com.omisoft.basic_java.intro.task7;

import java.util.Random;

public class RandomString {
	/**
	 * Generates a random string with random length
	 * @return 
	 * 			buf - random string
	 */
	public static StringBuffer randomString()
	{
		StringBuffer buf = new StringBuffer();
		String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		Random rand = new Random();
		int  n = rand.nextInt(60);
		
		for (int i = 0; i < n; i++) {
			double index = Math.random() * n;
			buf.append(a.charAt((int) index));
		}
		buf.toString();
		return buf;
	}
}
