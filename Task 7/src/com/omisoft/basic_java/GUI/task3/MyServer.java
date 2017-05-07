package com.omisoft.basic_java.GUI.task3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Creating the server program
 * @author bkoprinski
 *
 */
public class MyServer {
	private static boolean flag = true;
	private ServerSocket serverSocket;
	private JFrame err = new JFrame("");
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
		MyServer.flag = flag;
	}

	/**
	 * Constructor
	 */
	public MyServer()
	{
		try 
		{
			serverSocket = new ServerSocket(3333);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(err, "Can't connect ! Address already in use",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Method which accepts a client and starts a new thread
	 */
	public void server()
	{
		Socket socket = null;
		
		
		while(flag)
		{
			try 
			{
				socket = serverSocket.accept();
				new Thread(new HelloThread(socket)).start();
					
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		try 
		{
		    if(serverSocket != null)
		    {
			serverSocket.close();
		    }
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
