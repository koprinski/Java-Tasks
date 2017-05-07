package com.omisoft.basic_java.Threads.task6;

import java.util.Enumeration;
import java.util.Hashtable;
/**
 * Creating a hashtable
 * @author bkoprinski
 *
 */
public class TimeoutHashtable {
	
	private Hashtable<String, String> table = new Hashtable<String, String>();
	private Hashtable<String, Object> myObject = new Hashtable<String, Object>();
	private int sec;
	private boolean used;
	private Timer timer;

	
	public TimeoutHashtable(int sec)
	{
		this.setSec(sec);
		this.sec=sec;
		setUsed(false);
	}
	
	/**
	 * Method for entering a value in the hashtable
	 * if the key exists, the timer restarts and starts counting from 0
	 * @param key
	 * @param value
	 */
	public synchronized void put (String key, String value)
	{
		if((key != null) && (value != null))
		{
			if (table.containsKey(key))
			{
				table.put(key, value);
				setUsed(true);
				Timer time = (Timer) myObject.get(key);
				time.restart();
			}
			else
			{
				table.put(key, value);
				setUsed(false);
				timer = new Timer(key);
				myObject.put(key, timer);
			}
		}
		else
		{
			System.out.println("The value and the key cant be null!");
		}
	}
	
	/**
	 * Method for printing an element by key
	 * @param key
	 */
	public synchronized void get(String key)
	{
		String value = null ;
		if(key != null)
		{
			if(table.containsKey(key))
			{
				value = table.get(key);
				setUsed(true);	
				Timer time = (Timer) myObject.get(key);
				time.restart();
			}
		}
		else
		{
			System.out.println("The key cant be null!");
		}

		System.out.println("For key ["+key+"] the value is -> "+value);
	}
	
	/**
	 * Method for removing an element by key
	 * @param key
	 */
	public synchronized void remove(String key)
	{
		String value = null;
		if(key != null)
		{
			if(table.containsKey(key))
			{
				value = table.remove(key);
				setUsed(true);
				Timer time = (Timer) myObject.get(key);
				time.restart();
			}
			else
			{
				System.out.println("This key doesnt exist!");
			}
		}
		else
		{
			System.out.println("The key cant be null!");
		}
		System.out.println("The element is removed -> " + value);
	}


	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}


	/**
	 * @param used the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	/**
	 * Method for printing all the elements in the hashtable
	 */
	public void printTable() 
	{
        if(!table.isEmpty()) 
        {
        	System.out.println("The table contains (key->value) :\n");
        	for (Enumeration<String> e = table.elements(),k = table.keys(); k.hasMoreElements();)
        	{
        		System.out.println(k.nextElement()+" -> "+e.nextElement().toString());
        	}		
        } 
        else 
        {
        	System.out.println("The table is empty!\n");
        }
	}


	/**
	 * @return the sec
	 */
	public int getSec() {
		return sec;
	}


	/**
	 * @param sec the sec to set
	 */
	public void setSec(int sec) {
		this.sec = sec;
	}
	
	/**
	 * @return the table
	 */
	public Hashtable<String, String> getTable() {
		return table;
	}


	/**
	 * @param table the table to set
	 */
	public void setTable(Hashtable<String, String> table) {
		this.table = table;
	}
	
	/**
	 * Timer thread which checks in the hashtable if the key is expired and if yes
	 * it removes the element witch stands behind this key.
	 * @author bkoprinski
	 *
	 */
	public class Timer implements Runnable{
		
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
			while(!isUsed())
			{
				try
				{
					wait(sec*10000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				if (!isUsed())
				{
					break;
				}
				else
				{
					setUsed(false);
				}
			}
			if (table.containsKey(keyTimer))
			{
				table.remove(keyTimer);
				System.out.println("Objects timer has expired: " + keyTimer);
			}
			return ;
		}
		
	}

}


