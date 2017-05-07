package com.omisoft.basic_java.GUI.task4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Creating a Server application with GUI extending the CommonUI class
 * @author bkoprinski
 *
 */
public class ServerUI extends CommonUI implements ActionListener {
    private JButton startServer = new JButton("Start Server");
    private JButton stopServer = new JButton("Stop Server");
    private JTextArea textStartStop = new JTextArea("");

    /**
     * Constrictor
     */
    public ServerUI()
    {
	this.init();
	this.initSpecific();
    }
    
    /**
     * Initializing the specifics of the Server application
     */
    @Override
    public void initSpecific() {

	layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
	buttonPanel.setLayout(new GridLayout(5, 5));
	frame.add(buttonPanel, BorderLayout.CENTER);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
	textStartStop.setEditable(false);
	frame.add(textStartStop, BorderLayout.PAGE_START);
	buttonPanel.add(startServer);
	buttonPanel.add(stopServer);
	frame.repaint();

	startServer.addActionListener(this);
	stopServer.addActionListener(this);

    }

    /**
     * Method for giving actions to the buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
	Object source = e.getSource();

	if (source == startServer) 
	{
	    Thread thread1 = new Thread(new ServerThread());
	    thread1.start();
	    textStartStop.setText("");
	    textStartStop.append("Server is started ...");
	}

	if (source == stopServer)
	{
	    textStartStop.setText("");
	    textStartStop.append("Server is stopped ...");
	    Server.setFlag(false);
	}

    }

}
