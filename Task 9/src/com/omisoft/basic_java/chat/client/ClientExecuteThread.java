package com.omisoft.basic_java.chat.client;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



/**
 * Client thread
 * @author bkoprinski
 *
 */
public class ClientExecuteThread implements Runnable{
    private String a;
    private BufferedReader mSocketReader;
    private JTextArea textPrint;
    private Client client;
    private int endSymbol;
    private JFrame discon;
    /**
     * Constructor
     * @param a - String in which the new message is written
     * @param mSocketReader - socket reader
     * @param textPrint - Text area in which the new messages are printed
     * @param client - client instance
     */
    public ClientExecuteThread(String a, BufferedReader mSocketReader, JTextArea textPrint, Client client) 
    {
	this.a=a;
	this.mSocketReader=mSocketReader;
	this.textPrint=textPrint;
	this.client=client;
	discon = new JFrame();
    }
    
    /**
     * The thread runs while the flag is true
     * The flag is true when the client is connected to the server and if the client is 
     * disconnected the flag is false
     */
    @Override
    public void run() 
    {

	while (client.isFlag())
	{
	    try 
	    {
  	    
		a = mSocketReader.readLine();

		if (!a.equals(Client.KEEP_ALIVE_MESSAGE))
		{

		    String b;
		    if(a.contains("[") && a.contains("]") && a.contains("Chat."))
		    {
			
			
			endSymbol = a.indexOf("]");
			b = a.substring(1, endSymbol);
			String[] p=b.split(",");
			
			for (String s : p)
			{
			    ClientUI.listModel.addElement(s);
			}
			textPrint.append("\n" + a.substring(endSymbol+1, a.length()));
		    }
		    else if(a.contains("<") && a.contains(">") && a.contains("Chat."))
		    {
			endSymbol = a.indexOf(">");
			b = a.substring(1, endSymbol);
			String[] p=b.split(",");
			
			for (String s : p)
			{
			    ClientUI.listModel.addElement(s);
			}
		    }
		    else if(a.contains("<") && a.contains(">") && a.contains("offline."))
		    {
			ClientUI.listModel.removeAllElements();
		    }
		    else
		    {
			textPrint.append("\n" + a);
		    }

		}
	    } 
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
	    catch (NullPointerException j)
	    {
		JOptionPane.showMessageDialog(discon, "Your nickname contains [ , ] or already exists !", j.getMessage(), JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	    }
	}
	
    }

}
