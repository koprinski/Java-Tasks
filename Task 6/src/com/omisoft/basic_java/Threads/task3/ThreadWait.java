package com.omisoft.basic_java.Threads.task3;
/**
 * Starts two threads that count from 0 and if a symbol is entered the threads stop
 * and prints the value of the two counters
 * @author bkoprinski
 *
 */
public class ThreadWait implements Runnable{
	private static boolean flag;
    private int count;
    private int end;
    
    public ThreadWait(int count, int end)
	{
		this.count=count;
		this.end=end;
		flag = false;
	}
	
    
    
	@Override
	public void run() {
		synchronized (this) {
			while (true)
			{
				count++;
				System.out.println("counter = "+count);
				try
				{
					wait(1000);
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
				if ( count == end ) 
				{
					flag = true;
				}
				if ( flag ) return;

				}
			}
		}
		
	
}
