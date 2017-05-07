package com.omisoft.basic_java.GUI.task3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
/**
 * Creating a thread that keeps all the logic of the server.
 * This thread sends the date to every client who connects to the server
 * @author bkoprinski
 *
 */
public class HelloThread implements Runnable {
	private Socket socket;
	
	/**
	 * Constructor
	 * @param socket
	 */
	public HelloThread(Socket socket)
	{
		this.socket=socket;
	}
	
	@Override
	public void run() {
		OutputStreamWriter out = null;
		try 
		{
			out = new OutputStreamWriter(socket.getOutputStream());
			out.write("Hello! "+new Date()+ "\n");
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
			    if(out != null)
			    {
				out.close();
			    }
			    if (socket != null)
			    {
				socket.close();
			    }
				
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		
	}

}
