package com.omisoft.basic_java.IO.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Reverses the data from the text file.
 * @author bkoprinski
 *
 */
public class ReverseText {
	public static void reverseText()
	{
		String fileName = "reverseText.txt";
		Scanner fileReader = null;
		PrintWriter fileWriter = null;
		try
		{
			fileReader = new Scanner(new File(fileName));
			System.out.println("File " + fileName + " opened.");
			
			StringBuffer buf=new StringBuffer();
			while (fileReader.hasNextLine()) 
			{
				
				buf.append(fileReader.nextLine()+"\n");	
			}
			System.out.println("File info: "+buf);
			fileWriter = new PrintWriter(fileName);
			String reverse = buf.reverse().toString();
			fileWriter.println(reverse);
			System.out.println("Reverse file info: "+reverse);
			
		}
		catch (FileNotFoundException fnf) 
		{
			System.err.println("File " + fileName + " not found.");
		}
		catch (NullPointerException npe) 
		{
			System.err.println("File " + fileName + " not found.");
		}
		finally 
		{
			if (fileReader != null) 
			{
				fileReader.close();
			}
			if (fileWriter != null)
			{
				fileWriter.close();
			}
			System.out.println("File closed.");
		}
	}
}
