package com.omisoft.basic_java.Threads.task4;

public class ThreadNew implements Runnable {
    private static boolean flag;
    private int count;
    private int end;
    private String name;
    
    public ThreadNew(int count, int end, String name)
    {
	this.count=count;
	this.end=end;
	this.name=name;
	flag = false;
    }
	
    
    
	@Override
	public void run() 
	{
	    synchronized (this) 
	    {
		while (true)
		{
		    count++;
		    System.out.println(name+" - "+count);
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
		    notifyAll();
		}
		
	    }
	}
}
