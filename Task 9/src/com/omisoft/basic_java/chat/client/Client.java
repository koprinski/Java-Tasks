package com.omisoft.basic_java.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.omisoft.basic_java.chat.common.IClientMessages;

/**
 * Creating Client for our server
 * @author bkoprinski
 *
 */
public class Client {

    public final String SERVER_HOSTNAME = "localhost";
    public static String KEEP_ALIVE_MESSAGE = "!keep-alive";
    public final int SERVER_PORT = 2002;
    private BufferedReader mSocketReader;
    private PrintWriter mSocketWriter;
    private Socket socket;
    private JTextArea mess;
    private JTextArea textPrint;
    private JTextArea username;
    private String a;
    private boolean flag = true;
    private boolean flagError = true;
    private JFrame errConnection = new JFrame("");

    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    /**
     * Opening connection at port 2002
     * @param mess - reading message from the text area in ClientUI
     * @param textPrint - printing message in the text area in ClientUI
     * @param username - reading the username from the text area in ClientUI(Loggin form)
     */
    public Client(JTextArea mess, JTextArea textPrint, JTextArea username)
    {
	try 
	{
	    this.username=username;
	    this.mess=mess;
	    this.textPrint=textPrint;
	    socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
	    mSocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    mSocketWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	    System.out.println(IClientMessages.CONNECTION_ATTEMPT + SERVER_HOSTNAME + ":" + SERVER_PORT);
	} 
	catch (UnknownHostException e) 
	{
	    e.printStackTrace();
	} 
	catch (IOException e) 
	{
	    System.err.println(IClientMessages.DISCONNECT_CLIENT + SERVER_HOSTNAME + ":" + SERVER_PORT);
	    if (flagError)
	    {
		JOptionPane.showMessageDialog(errConnection, IClientMessages.DISCONNECT_CLIENT + SERVER_HOSTNAME + ":" + SERVER_PORT,e.getMessage(), JOptionPane.ERROR_MESSAGE);
		ClientUI.frame2.dispose();
	    }
	}
    }
   
    
    /**
     * Method for which generates a new message and prints it in the Text area in ClientUI
     * Creates a new Thread for the new client
     */
    public void connectClient()
    {
	if(isFlag())
	{
	    if (!(username.getText().equals("")))
     		{
		mSocketWriter.println(username.getText());
		mSocketWriter.flush();
     		}
     		else
     		{
     		    mSocketWriter.println(mess.getText());
     		    mSocketWriter.flush();
     		}
	    new Thread(new ClientExecuteThread(a, mSocketReader, textPrint,this)).start();
	}
    }
    
}