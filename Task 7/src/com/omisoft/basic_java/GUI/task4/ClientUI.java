package com.omisoft.basic_java.GUI.task4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Creating a Client application with GUI extending the CommonUI class
 * @author bkoprinski
 *
 */
public class ClientUI extends CommonUI implements ActionListener{
    private JButton startClient = new JButton("Connect to Server");
    private JButton stopClient = new JButton("Stop the connection");
    private JTextArea textStartStop = new JTextArea("");
    private JTextArea textPrint = new JTextArea("");
    
    /**
     * Constructor
     */
    public ClientUI()
    {
	this.init();
	this.initSpecific();
    }
   
    /**
     * Initializing the specifics of the Client application
     */
    @Override
    public void initSpecific() 
    {
	layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
	buttonPanel.setLayout(new GridLayout(3, 5));
	frame.add(buttonPanel, BorderLayout.CENTER);
	
	textPrint.setEditable(false);
	textStartStop.setEditable(false);
	frame.add(textStartStop, BorderLayout.PAGE_START);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
	frame.setSize(550, 300);
	buttonPanel.add(startClient);
	buttonPanel.add(stopClient);
	buttonPanel.add(textPrint);
	frame.repaint();
	
	startClient.addActionListener(this);
	stopClient.addActionListener(this);
	
    }
    /**
     * Method for giving actions to the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();

	if (source == startClient) 
	{
	    Client obj = new Client();
	    Client.setFlagC(true);
	    textStartStop.setText("");
	    textStartStop.append("Client is connected ...");
	    textPrint.append(obj.start()+"\n");
	}
	if (source == stopClient)
	{
	    textStartStop.setText("");
	    textStartStop.append("Client is disconnected ...");
	    Client.setFlagC(false);
	    textPrint.setText("");
	}
    }

}
