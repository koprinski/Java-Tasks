package com.omisoft.basic_java.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


/**
 * Main class of the server
 * @author bkoprinski
 *
 */
public class Server {

    public static final int LISTENING_PORT = 2002;
    public static String KEEP_ALIVE_MESSAGE = "!keep-alive";
    public static int CLIENT_READ_TIMEOUT = 5*60*1000;
    private static ServerSocket mServerSocket;
    private static OnlineUsersThread mOnlineUsers;
    private JTextArea textField;
    private static JFrame errConnection = new JFrame("");
    

    /**
     * Constructor
     * @param textField
     */
    public Server(JTextArea textField)
    {
	this.textField=textField;
    }
    
    /**
     * Starting the server by calling the 2 methods for listening from the socket and handling 
     * the client connections
     * Starting a new thread
     */
    public void startServer() {
	// Start listening on the server socket
	bindServerSocket();
	// Start the OnlineUsers thread
	mOnlineUsers = new OnlineUsersThread(textField);
	mOnlineUsers.start();
	// Infinitely accept and handle client connections
	handleClientConnections();
	}
   
    /**
     * Method for listening from the server socket
     */
    private static void bindServerSocket() 
    {
	try 
	{
	    mServerSocket = new ServerSocket(LISTENING_PORT);
	    System.out.println("Omisoft Chat started on " + "port " + LISTENING_PORT);
	} 
	catch (IOException ioe) 
	{
	    System.err.println("Can not start listening on " +"port " + LISTENING_PORT);
	    ioe.printStackTrace();
	    JOptionPane.showMessageDialog(errConnection, "Can not start listening on " +"port " + LISTENING_PORT,ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
	}
    }
    
    /**
     * Handling the users, connecting to the server
     */
    private static void handleClientConnections() 
    {
	while (true) 
	{
	    try 
	    {
		Socket socket = mServerSocket.accept();
		ClientInformationInServer client = new ClientInformationInServer();
		client.mSocket = socket;
		ClientMessagesReadThread clientListener = new ClientMessagesReadThread(client, mOnlineUsers);
		SendMessageThread clientSender = new SendMessageThread(client, mOnlineUsers);
		client.mClientListener = clientListener;
		clientListener.start();
		client.mClientSender = clientSender;
		clientSender.start();
		mOnlineUsers.addClient(client);

	    }
	    catch (IOException ioe) 
	    {
		ioe.printStackTrace();
	    }
	}
    }
}
