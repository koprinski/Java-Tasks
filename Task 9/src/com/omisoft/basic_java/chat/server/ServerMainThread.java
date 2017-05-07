package com.omisoft.basic_java.chat.server;

import javax.swing.JTextArea;

/**
 * Main thread of the server
 * @author bkoprinski
 *
 */
public class ServerMainThread extends Thread{
    private JTextArea textField;
    
    /**
     * Constructor
     * @param textField
     */
    public ServerMainThread(JTextArea textField)
    {
	this.textField=textField;
    }
    
    /**
     * Starting the server when the button is pushed
     */
    @Override
    public void run() {

	Server obj = new Server(textField);
	obj.startServer();
	
	
    }

}
