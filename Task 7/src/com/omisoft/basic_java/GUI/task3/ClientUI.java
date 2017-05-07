package com.omisoft.basic_java.GUI.task3;

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
	buttonPanel.setLayout(new GridLayout(5, 5));
	frame.add(buttonPanel, BorderLayout.CENTER);
	
	textPrint.setEditable(false);
	frame.add(textPrint, BorderLayout.PAGE_END);
	textStartStop.setEditable(false);
	frame.add(textStartStop, BorderLayout.PAGE_START);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
	buttonPanel.add(startClient);
	buttonPanel.add(stopClient);
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
	    MyClient obj = new MyClient();
	    MyClient.setFlagC(true);
	    textStartStop.setText("");
	    textStartStop.append("Client is connected ...");
	    textPrint.setText("");
	    textPrint.append(obj.client()); 
	}
	if (source == stopClient)
	{
	    textStartStop.setText("");
	    textStartStop.append("Client is disconnected ...");
	    MyClient.setFlagC(false);
	    textPrint.setText("");
	}
    }

}
