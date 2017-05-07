package com.omisoft.basic_java.GUI.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Creating a thread that keeps all the logic of the server.
 * This thread reads the text written by the client and reverses it
 * @author bkoprinski
 *
 */
public class ServerThread implements Runnable {
    private Socket socket;
    private BufferedReader SocketReader;
    private PrintWriter SocketWriter;
    
    /**
     * Constructor
     * @param socket
     */
    public ServerThread(Socket socket)
    {
	this.socket=socket;
	try 
	{
	    SocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    SocketWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	} 
	catch (IOException e) 
	{
	    e.printStackTrace();
	}
	
    }
    @Override
    public void run() {
	
	try 
	{
	    SocketWriter.print("Wellcome! " + "\n");
	    SocketWriter.flush();
	    while(true && (Server.isFlag()==true))
	    {
		String message = SocketReader.readLine();
		if (message.equals(".") == true)
		{
		    break;
		}
		else
		{
		    String reverse = writeReversedMessage(message);
		    SocketWriter.println("The reverse of "+ message+ " is "+reverse);
		    SocketWriter.flush();
		}
		
	    }
	} 
	catch (IOException e) 
	{
	    e.printStackTrace();
	}
	catch(NullPointerException e)
	{
	    System.err.println("Nullpointer");
	}
	finally
	{
	    try 
	    {
		if(SocketWriter != null)
		{
		    SocketWriter.close();
		}
		if(SocketReader != null)
		{
		    SocketReader.close();
		}
		if(socket != null)
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
    
    /**
     * Method for reversing a text message
     * @param message
     * @return
     */
    public String writeReversedMessage(String message)
    {
	return new StringBuilder(message).reverse().toString();
    }

}
