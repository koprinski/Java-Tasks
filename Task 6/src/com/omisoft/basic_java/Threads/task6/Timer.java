package com.omisoft.basic_java.Threads.task6;

import java.util.TimerTask;

/**
 * Timer thread which checks in the hashtable if the key is expired and if yes
 * it removes the element witch stands behind this key.
 * @author bkoprinski
 *
 */
public class Timer extends TimerTask{
	
	private String keyTimer;

	
	public Timer(String key) {
		this.keyTimer = key;
        new Thread(this, key).start();
	}

	 public synchronized void restart()
	 {
         notify();
	 }

	
	@Override
	public synchronized void run() 
	{	
		TimeoutHashtable obj = new TimeoutHashtable(1);
		
		while(!obj.isUsed())
		{
			try
			{
				wait(100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (!obj.isUsed())
			{
				break;
			}
			else
			{
				obj.setUsed(false);
			}
		}
		if (obj.getTable().containsKey(keyTimer))
		{
			obj.getTable().remove(keyTimer);
			System.out.println("Objects timer has expired: " + keyTimer);
			System.exit(0);
		}
		return ;
	}
	
}
