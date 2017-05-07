package com.omisoft.basic_java.chat.server;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Creating the server graphic look
 * @author bkoprinski
 *
 */
public class ServerUI implements ActionListener {
    private JFrame frame;
    private JTextArea textField;
    private JButton startServer;
    private JButton stopServer;
    private JPanel panelButtons;
    private JLabel firmLabel;
    private JScrollPane scroll;
    private GridBagConstraints c;
    
    /**
     * Constructor
     */
    public ServerUI()
    {
	frame = new JFrame("Omisoft Chat Server");
	textField = new JTextArea("");
	startServer = new JButton("Start Server");
	stopServer = new JButton("Stop Server");
	firmLabel = new JLabel("Omisoft Chat®");
	scroll = new JScrollPane(textField);
	panelButtons = new JPanel(new GridBagLayout());
	c = new GridBagConstraints();
    }
    
    /**
     * Creating the frame of the server
     */
    public void frameServer()
    {
	frame.setSize(900, 600);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setVisible(true);
	textField.setBackground(Color.LIGHT_GRAY);
	Font f = textField.getFont();
	Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize()+3);
	textField.setFont(f2);
	textField.setEditable(false);
//	DefaultCaret caret = (DefaultCaret)textField.getCaret();  
//	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); 
	
	// Adding Start Server button at the top

	c.ipady = 40;
	c.ipadx = 150;
	c.weighty = 1.0;
	c.weightx = 0.5;
	c.insets = new Insets(10,1,0,0);
	c.gridx = 0;
	c.gridwidth = 1;
	c.gridy = 0;
	panelButtons.add(startServer, c);
	
	// Adding Stop Server button at the top

	c.ipady = 40;
	c.ipadx = 150;
	c.weighty = 1.0;
	c.weightx = 0.5;
	c.insets = new Insets(10,1,0,0);
	c.gridx = 1;
	c.gridwidth = 1;
	c.gridy = 0;
	panelButtons.add(stopServer, c);
	
	// Adding TextField in the panel
	
	c.fill=GridBagConstraints.HORIZONTAL;
	c.ipady= 500;
	c.weightx =0.1;
	c.gridwidth = 10;
	c.gridx = 0;
	c.gridy = 1;
	c.anchor = GridBagConstraints.PAGE_END;
	panelButtons.add(scroll, c);
	
	// Adding Label at the bottom
	
	c.fill=GridBagConstraints.PAGE_END;
	c.ipady = 20;
	c.insets = new Insets(0,0,0,0);
	c.gridx = 0;
	c.gridy = 2;
	c.anchor = GridBagConstraints.WEST;
	panelButtons.add(firmLabel, c);
	frame.add(panelButtons);
	
	
	panelButtons.validate();
	panelButtons.repaint();
	frame.validate();
	frame.repaint();
	
	
	startServer.addActionListener(this);
	stopServer.addActionListener(this);
    }
    
    /**
     * Creating action events to all the buttons in the server application
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	Thread thread1 = null;
	if (source == startServer) 
	{
	    SendMessageThread.setFlag(true);
	    thread1 = new Thread(new ServerMainThread(textField));
	    thread1.start();
	    textField.setText("");
	    textField.append("Server is started ...");
	}
	if (source == stopServer) 
	{
	    SendMessageThread.setFlag(false);
	    textField.setText("");
	    textField.append("Server is stopped ...");
	    
	}
    }
}
