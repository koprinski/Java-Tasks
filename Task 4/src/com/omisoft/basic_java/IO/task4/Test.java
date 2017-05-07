package com.omisoft.basic_java.IO.task4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	/**
	 * Tests the transfer between InputStream and OutputStream.
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try{
		in = new FileInputStream("/home/bkoprinski/dev/bkoprinski/Task 4/InputStream.txt");
		out = new FileOutputStream("/home/bkoprinski/dev/bkoprinski/Task 4/OutputStream.txt");

		
		TransferObject obj = new TransferObject(in,out);
		System.out.println("Transfered bytes = "+obj.transfer(10, 0));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				out.flush();
				if (in != null)
				{
					in.close();
				}
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
	}
}
