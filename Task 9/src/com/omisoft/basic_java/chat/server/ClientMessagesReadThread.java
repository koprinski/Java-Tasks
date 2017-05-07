package com.omisoft.basic_java.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import com.omisoft.basic_java.chat.common.IServerMessages;

/**
 * Thread for reading messages from the client
 * @author bkoprinski
 *
 */
public class ClientMessagesReadThread extends Thread 
{
    private OnlineUsersThread mServerDispatcher;
    private ClientInformationInServer mClient;
    private BufferedReader mSocketReader;
    private PrintWriter SocketWriter;
    private Socket socket;
    private ArrayList<String> list = new ArrayList<String>();
    private String logginUsername;
    private ArrayList<String> obj = SingletonArray.getInstance();
    
    /**
     * Constructor
     * @param aClient
     * @param aSrvDispatcher
     * @throws IOException
     */
    public ClientMessagesReadThread(ClientInformationInServer aClient, OnlineUsersThread aSrvDispatcher) throws IOException 
    {
	
	mClient = aClient;
	mServerDispatcher = aSrvDispatcher;
	socket = aClient.mSocket;
	socket.setSoTimeout(Server.CLIENT_READ_TIMEOUT);
	mSocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	SocketWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    
    /**
     * Starts a new thread for every new client
     * When a client is connected he writes a username and if it is valid he starts writing messages
     */
    public void run() {
	try
	{
//	    SocketWriter.print("Username : ");
//	    SocketWriter.flush();
	    logginUsername = mSocketReader.readLine();
	    
	    
	    boolean b = false;
	    for (String s : obj)
	    {
		if (s.equals(logginUsername))
		{
		    b = true;
		    break;
		}
	    }
	    
	
	    
	   try{
	    if(b || logginUsername.contains("[") || logginUsername.contains("]") ||  logginUsername.contains("["+"]"))
	    {
		SocketWriter.print(IServerMessages.INVALID_NICK + logginUsername + "\nYour nickname contains [ , ] or already exists ! \n");
		SocketWriter.flush();
		return;
	    }
	    else
	    {
		SocketWriter.print(IServerMessages.NICK_OK+logginUsername+"\n");
		SocketWriter.flush();
		list.add(logginUsername);
		obj.add(logginUsername);	
		SocketWriter.print(obj);
		SocketWriter.flush();
		
	    }
	    
	   }
	   catch (NullPointerException k)
	   {
	       // Nobody connected to the chat
	   }
	    

	    
	    //Sends to all the clients message who connected to the chat
	    mServerDispatcher.onlineClients(logginUsername);
	
	    while (!isInterrupted()) 
	    {
		try 
		{
		    String message = mSocketReader.readLine();
		    if (message == null)
		    {
			break;
		    }	
		    mServerDispatcher.displayMessage(list, mClient, message);

		} 
		catch (SocketTimeoutException ste) 
		{
		    mClient.mClientSender.sendKeepAlive();
		}
	    }
	}
	catch (IOException ioex) 
	{
	    // Problem reading from socket (broken connection)
	}
	finally
	{
	    try 
	    {
		if(SocketWriter != null)
		{
		    SocketWriter.close();
		}
		if(mSocketReader != null)
		{
		    mSocketReader.close();
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
	    // Communication is broken. Interrupt both listener and sender threads
	    mClient.mClientSender.interrupt();
	    mServerDispatcher.deleteClient(mClient);
	    mServerDispatcher.offlineClients(logginUsername);
	    obj.remove(logginUsername);

	
    }
}