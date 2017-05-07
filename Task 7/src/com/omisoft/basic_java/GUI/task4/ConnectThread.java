package com.omisoft.basic_java.GUI.task4;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 * Creating a thread that keeps all the logic of the server.
 * This thread sends the information of every client who connects to the server
 * @author bkoprinski
 *
 */
public class ConnectThread implements Runnable{
    private Socket socket;
    private Hashtable<InetAddress, Socket> table = new Hashtable<InetAddress, Socket>();
    private int count;
    private ArrayList<Integer> list;
  
    /**
     * Constructor
     * @param socket
     * @param count
     * @param list
     */
    public ConnectThread(Socket socket, int count, ArrayList<Integer> list)
    {
	this.socket=socket;
	this.count=count;
	this.list=list;
    }
    
    @Override
    public void run() {
	OutputStreamWriter out = null;
	try 
	{
	    InetAddress key = socket.getLocalAddress();
	    table.put(key, socket);
	    out = new OutputStreamWriter(socket.getOutputStream());
	    out.write("Client information: "+ table.get(key)+" is number "+count+"\n");
	    for (int i = 0; i < list.size(); i++) 
	    {
		out.write("Client connected before you = "+list.get(i).toString()+" port"+"\n");
	    }
		
	} 
	catch (IOException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    try 
	    {
		if(out != null)
		{
		    out.close();
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

}
