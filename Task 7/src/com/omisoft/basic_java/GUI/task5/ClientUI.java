package com.omisoft.basic_java.GUI.task5;

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
    private JButton startClient = new JButton("Reverse text");
    private JTextArea textStartStop = new JTextArea("Client is connected ...");
    private JTextArea textWrite = new JTextArea("");
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
	buttonPanel.setLayout(new GridLayout(3, 4));
	frame.add(buttonPanel, BorderLayout.CENTER);
	
	textPrint.setEditable(false);

	textStartStop.setEditable(false);
	frame.add(textStartStop, BorderLayout.PAGE_START);
	frame.setLocationRelativeTo(null);
	frame.setResizable(true);
	frame.setVisible(true);
	buttonPanel.add(textWrite);
	buttonPanel.add(startClient);
	buttonPanel.add(textPrint);
	frame.repaint();
	
	startClient.addActionListener(this);
	
    }
    
    /**
     * Method for giving actions to the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();

	if (source == startClient) 
	{

	    Thread thread1 = new Thread(new ClientThread(textPrint,textWrite,textStartStop));
	    thread1.start();
	    
	}

    }

}
