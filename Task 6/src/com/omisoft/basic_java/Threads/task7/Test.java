package com.omisoft.basic_java.Threads.task7;

import java.util.Timer;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Timer time = new Timer("");
		
		MyTimer t = new MyTimer();
		
		time.schedule(t, 0, 1000);
		

	}

}
