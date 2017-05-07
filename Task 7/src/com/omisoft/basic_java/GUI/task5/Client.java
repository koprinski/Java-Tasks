package com.omisoft.basic_java.GUI.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * Creating a client program
 * @author bkoprinski
 *
 */
public class Client {
    private Socket socket;
    private JTextArea textPrint = new JTextArea("");
    private JTextArea textWrite = new JTextArea("");
    private JTextArea textStartStop = new JTextArea("");
    private JFrame err = new JFrame("");
    
    /**
     * Constrictor
     * @param textPrint
     * @param textWrite
     * @param textStartStop
     */
    public Client(JTextArea textPrint, JTextArea textWrite, JTextArea textStartStop)
    {
	this.textPrint=textPrint;
	this.textWrite=textWrite;
	this.textStartStop=textStartStop;
    }
    
    /**
     * Method for connecting to a local host and reading the information given from the socket
     * @return - reversed text
     */
    public String startClient()
    {
	socket = null;
	String reverse = null;
	try 
	{
	    try
	    {
		socket = new Socket("localhost", 7002);
	    }
	    catch(ConnectException e)
	    {
		JOptionPane.showMessageDialog(err, "Can't connect to server !",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	    }
	    BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
	    String welcomeMessage = socketReader.readLine();
	    textStartStop.setText(welcomeMessage);
	    String word = textWrite.getText();
	    socketWriter.println(word);
	    socketWriter.flush();
	    reverse = socketReader.readLine();
	    textPrint.setText(reverse);
		
	} 
	catch (UnknownHostException e) 
	{
	    e.printStackTrace();
	} 
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    try
	    {
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
	return reverse;
    }
}
