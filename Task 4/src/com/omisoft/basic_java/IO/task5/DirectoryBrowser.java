package com.omisoft.basic_java.IO.task5;

import java.io.File;

public class DirectoryBrowser {
	/**
	 * Method for finding a directory or a file on the computer.
	 * @param path - String - the path that the user gives
	 */
	public static void listContent(String path)
	{
		try{
			
		
			File browse = new File(path);
			String[] list = browse.list();
		
			String output = "";
		if (browse.exists()){
			if (browse.isFile()== true)
			{
				System.out.println("This is a file.");
				System.out.println("File name: "+browse.getName());
			}
			else
			{
				for (int i = 0; i < list.length; i++) 
				{
					output += list[i]+"\n";
				}
				System.out.println(output);
			}
		}
		else
		{
			System.out.println("This file does not exist!");
		}
		}
		catch(NullPointerException e)
		{
			System.err.println("The directory that you have choose does not exist!");
		}
		
	}
}
