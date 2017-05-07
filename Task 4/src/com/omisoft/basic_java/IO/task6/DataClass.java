package com.omisoft.basic_java.IO.task6;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class DataClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Method for writing in file
	 * @param path - String - directory of the file
	 * @param person - object that definates person name and age
	 * @return
	 */
	public DataClass saveObject(String path)
	{	
		try
		{
			DataClass person = new DataClass();
			person.setName("Georgi");
			person.setAge(21);
			FileOutputStream outFile = new FileOutputStream(path);
			out = new ObjectOutputStream(outFile);
			out.writeObject(person);
			System.out.println("The file is saved.");
		    out.flush();
			
		}
		catch(IOException e)
		{
			System.err.println("Error during reading/writing.");
		}
		finally
		{
			try 
			{
				if (out != null)
				{
					out.close();
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	/**
	 * Method for reading from file
	 * @param path - String - directory of the file
	 * @param obj - object that is defined in the saveObject method
	 * @return
	 */
	public DataClass getObject(String path)
	{
		try
	    {
			FileInputStream inFile = new FileInputStream(path);
			in = new ObjectInputStream(inFile);
			Object obj = in.readObject();
			DataClass restoredDataClass = (DataClass) obj;
			System.out.println("Name: " + restoredDataClass.name);
		    System.out.println("Age: " + restoredDataClass.age);
		    System.out.println("The object is restored.");
	    	
	    }
	    catch(IOException | ClassNotFoundException e)
	    {
	      e.printStackTrace();
	    }
		finally
		{
			try {
				if (in != null)
				{
					in.close();
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return null;
	}
}
