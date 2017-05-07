package com.omisoft.basic_java.GUI.task4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Creating the server program
 * @author bkoprinski
 *
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private static boolean flag = true;
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
        Server.flag = flag;
    }
    private int count;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    
    /**
     * Constructor
     */
    public Server()
    {
	
	try 
	{
	    serverSocket = new ServerSocket(3334);
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
    public void connect()
    {
	while(flag)
	{
	    try 
	    {
		
		count++;
		socket = serverSocket.accept();
		list.add(socket.getPort());
		
		new Thread(new ConnectThread(socket, count, list)).start();
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
