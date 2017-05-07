package com.omisoft.basic_java.chat.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

/**
 * Thread for sending a message to all the clients
 * @author bkoprinski
 *
 */
class SendMessageThread extends Thread {
    private Vector<String> mMessageQueue = new Vector<String>();
    private OnlineUsersThread mServerDispatcher;
    private ClientInformationInServer mClient;
    private PrintWriter mOut;
    public static boolean flag = true;
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
        SendMessageThread.flag = flag;
    }

    /**
     * Constructor
     * @param aClient
     * @param aServerDispatcher
     * @throws IOException
     */
    public SendMessageThread(ClientInformationInServer aClient, OnlineUsersThread aServerDispatcher) throws IOException
    {
	mClient = aClient;
	mServerDispatcher = aServerDispatcher;
	Socket socket = aClient.mSocket;
	mOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()) );
    }

    /**
     * Adding message to the queue
     * @param aMessage
     */
    public synchronized void sendMessage(String aMessage) 
    {
	mMessageQueue.add(aMessage);
	notify();
    }
    
    /**
     * Keeping an alive message in the server
     */
    public void sendKeepAlive() 
    {
	sendMessage(Server.KEEP_ALIVE_MESSAGE);
    }
    
    /**
     * Getting the message from the queue
     * @return
     * @throws InterruptedException
     */
    private synchronized String getNextMessageFromQueue()  throws InterruptedException 
    { 	
	while (mMessageQueue.size()==0)
	    wait();
	String message = (String) mMessageQueue.get(0);
	mMessageQueue.removeElementAt(0);
	return message;
    }
    
    /**
     * Flushing the message after it is pulled from the queue to all the clients
     * @param aMessage
     */
    private void sendMessageToClient(String aMessage) 
    {
	mOut.println(aMessage);
	mOut.flush();
    }
    
    public void run() {
	try 
	{
	    while (!isInterrupted() && flag)
	    {
		String message = getNextMessageFromQueue();
		sendMessageToClient(message);
	    }
	} 
	catch (Exception e)
	{
	// Commuication problem
	}
	// Communication is broken. Interrupt both listener
	// and sender threads
	mClient.mClientListener.interrupt();
	mServerDispatcher.deleteClient(mClient);
    }
}
    