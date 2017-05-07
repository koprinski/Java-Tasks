package com.omisoft.basic_java.GUI.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Creating a client program
 * @author bkoprinski
 *
 */
public class MyClient {
	
    private static boolean flagC = true;
    private Socket socket;
    private JFrame err = new JFrame("");
    /**
     * @return the flagC
     */
    public static boolean isFlagC() {
        return flagC;
    }
    /**
     * @param flagC the flagC to set
     */
    public static void setFlagC(boolean flagC) {
        MyClient.flagC = flagC;
    }
    
    /**
     * Method for connecting to a local host and reading the information given from the socket
     * @return - the information (text+Date)
     */
    public String client()
    {
	socket = null;
	String str = null;
	if (flagC){
	try 
	{
	    try
	    {
		socket = new Socket("localhost", 3333);
	    }
	    catch(ConnectException e)
	    {
		JOptionPane.showMessageDialog(err, "Can't connect to server !",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	    }
	    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    str=in.readLine();
	} 
	
	catch (UnknownHostException e)
	{
	    e.printStackTrace();
	} 
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	}
	else
	{
	    try 
	    {
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
	return str;	
    }
}
