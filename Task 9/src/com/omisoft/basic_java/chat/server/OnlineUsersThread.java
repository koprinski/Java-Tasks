package com.omisoft.basic_java.chat.server;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;

import com.omisoft.basic_java.chat.common.IServerMessages;

/**
 * Thread which send to all the users messages with the information for their actions
 * @author bkoprinski
 *
 */
public class OnlineUsersThread extends Thread {
    private List<String> mMessageQueue = new ArrayList<String>();
    private List<Object> mClients = new ArrayList<Object>();
    private SimpleDateFormat sdf;
    private String newDateString;
    private JTextArea textField;


    /**
     * Constructor
     * @param textField
     */
    public OnlineUsersThread(JTextArea textField)
    {
	this.textField=textField;
	sdf = new SimpleDateFormat("HH:mm:ss");
    }
    
    /**
     * Adding new instance of the client
     * @param aClient
     */
    public synchronized void addClient(ClientInformationInServer aClient)
    {

	mClients.add(aClient);

    }
    
    /**
     * Sending message to all the clients if somebody connects to the server
     * @param a
     */
    public synchronized void onlineClients(String a)
    {	
	newDateString = sdf.format(new Date());
	for (int i = 0; i < mClients.size(); i++) 
	{
	    ClientInformationInServer client = (ClientInformationInServer) mClients.get(i);
	    client.mClientSender.sendMessage("< " + a + IServerMessages.CLIENT_CONNECTED);
	    
	}
	textField.append("\n" + newDateString + " - < " + a + IServerMessages.CLIENT_CONNECTED);
    }

    /**
     * Sending message to all the clients if somebody disconnects from the server
     * @param offline
     */
    public synchronized void offlineClients(String offline) 
    {
	newDateString = sdf.format(new Date());
	try
	{
	    textField.append("\n" + newDateString + " - < " + offline + IServerMessages.CLIENT_DISCONNECTED);
	}
	catch(java.lang.Error p)
	{
	    // Exception for empty textField if the client is stopped before logging in
	}
	
	for (int i = 0; i < mClients.size(); i++) 
	{
	    ClientInformationInServer client = (ClientInformationInServer) mClients.get(i);
	    client.mClientSender.sendMessage("< " + offline + IServerMessages.CLIENT_DISCONNECTED);	    
	}
    }
    
    /**
     * Deleting instance of the client if he goes offline
     * @param aClient
     */
    public synchronized void deleteClient(ClientInformationInServer aClient) 
    {
	int clientIndex = mClients.indexOf(aClient);
	if (clientIndex != -1)
	{
//	    mClients.removeElementAt(clientIndex);
	    mClients.remove(clientIndex);
	}
    }
    
    /**
     * Displaying all the messages send form the clients
     * They are kept in a queue
     * @param list
     * @param aClient
     * @param aMessage
     */
    public synchronized void displayMessage(ArrayList<String> list, ClientInformationInServer aClient, String aMessage) 
    {

	for (int i = 0; i < list.size(); i++)
	{
	    aMessage = list.get(i) + ":" + aMessage;
	}
	mMessageQueue.add(aMessage);
	notify();
    }
    
    /**
     * Method for getting the next message from the queue
     * @return
     * @throws InterruptedException
     */
    private synchronized String getNextMessageFromQueue() throws InterruptedException 
    {
	while (mMessageQueue.size()==0)
	    wait();
	String message = (String) mMessageQueue.get(0);
//	mMessageQueue.removeElementAt(0);
	mMessageQueue.remove(0);
	return message;
    }
    
    /**
     * Sending the message to all the clients after it is pulled form the queue
     * @param aMessage
     */
    private void sendMessageToAllClients(String aMessage)
    {
	for (int i=0; i<mClients.size(); i++) 
	{
	    ClientInformationInServer client = (ClientInformationInServer) mClients.get(i);
	    client.mClientSender.sendMessage(aMessage);
	}
    }
    
    public void run() {
	try 
	{
	    while (true) 
	    {
		String message = getNextMessageFromQueue();
		sendMessageToAllClients(message);
	    }
	}
	catch (InterruptedException ie) 
	{
		// Thread interrupted. Stop its execution
	}
	
    }
}