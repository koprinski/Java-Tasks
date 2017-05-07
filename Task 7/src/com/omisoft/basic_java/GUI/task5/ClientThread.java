package com.omisoft.basic_java.GUI.task5;

import javax.swing.JTextArea;
/**
 * Creating a thread for the client application button
 * @author bkoprinski
 *
 */
public class ClientThread implements Runnable{
    private JTextArea textPrint = new JTextArea("");
    private JTextArea textWrite = new JTextArea("");
    private JTextArea textStartStop = new JTextArea("");
    
    /**
     * Constructor
     * @param textPrint
     * @param textWrite
     * @param textStartStop
     */
    public ClientThread(JTextArea textPrint, JTextArea textWrite, JTextArea textStartStop)
    {
	this.textPrint=textPrint;
	this.textWrite=textWrite;
	this.textStartStop=textStartStop;
    }
    @Override
    public void run() {
	Client obj = new Client(textPrint,textWrite,textStartStop);
	obj.startClient();
	
    }

}
