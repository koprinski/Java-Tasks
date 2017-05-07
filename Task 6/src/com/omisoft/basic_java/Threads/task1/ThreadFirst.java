package com.omisoft.basic_java.Threads.task1;
/**
 * Starts a thread that counts from 0 and if a symbol is entered the thread stops
 * and prints the value of the counter
 * @author bkoprinski
 *
 */
public class ThreadFirst implements Runnable {
	private int count;
	private static boolean flag = true;
	
	/**
	 * @return the flag
	 */
	public static boolean isFlag() {
	    return flag;
	}


	/**
	 * @param flag the flag to set
	 */
	public static void setFlag(boolean flag) {
	    ThreadFirst.flag = flag;
	}


	public ThreadFirst(int count)
	{
		this.count=count;
	}
	

	@Override
	public void run() {
		
		
			try {
				while(flag) 
				{
				System.out.println(count);
				Thread.sleep(1000);
				count++;
				}
			
			}
			catch (InterruptedException e) 
			{
			    e.printStackTrace();
			}
		
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
