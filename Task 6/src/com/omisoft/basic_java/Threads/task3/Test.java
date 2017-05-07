package com.omisoft.basic_java.Threads.task3;

/**
 * Tests the sleep() and wait() methods
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		/*
		Thread first =new Thread(new ThreadSleep(0,10));
		Thread second =new Thread(new ThreadSleep(0,20));
		first.start();
		second.start();
		*/
		
		
		Thread t1 = new Thread(new ThreadWait(0,10));
		Thread t2 = new Thread(new ThreadWait(0,20));
		t1.start();
		t2.start();
		
	}

}
