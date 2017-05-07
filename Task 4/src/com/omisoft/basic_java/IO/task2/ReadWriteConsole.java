package com.omisoft.basic_java.IO.task2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
/**
 * Reads text from the console and writes it in text file
 * @exception IOException - Error during reading/writing
 * @author bkoprinski
 *
 */
public class ReadWriteConsole {
	public static void ReadWrite()
	{
		PrintStream out = null;
		try
		{
			out = new PrintStream(new FileOutputStream("output.txt"));
			String text="";
			
			System.out.print ("Enter some text: ");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			String buffer = "";
			while (buffer.equals(".") == false) 
			{
				buffer = input.readLine();
				text = text + "\n" + buffer ;
				if (text.charAt(text.length()-1)=='.')
				{
					text = text.substring(0, text.length()-1);
				}
				
			}
			out.print(text);
			System.out.println(text);
			System.out.println("The text is saved in file: output.txt");
				
		}
		catch(IOException e)
		{
			System.err.println("Error during reading/writing.");
		}
		finally
		{
			if (out != null)
			{
				out.close();
			}
		}
	
	}
}
