package com.omisoft.basic_java.Threads.task7;

import java.util.TimerTask;
/**
 * Creating a timer for 6 seconds using the TimerTast class
 * @author bkoprinski
 *
 */
public class MyTimer extends TimerTask {
	private int seconds = 0;
	
	
	@Override
	public void run() {
		
			
		
		seconds ++;
		if(seconds < 6)
		{
			System.out.println("The timer is still running...");
		}
		else
		{
			this.cancel();
			System.out.println("The timer ended.");
			System.exit(0);
		}
	
	}
	
}
