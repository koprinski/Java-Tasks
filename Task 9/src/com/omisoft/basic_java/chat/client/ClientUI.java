package com.omisoft.basic_java.chat.client;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultCaret;



/**
 * Creating Graphic design for our client
 * @author bkoprinski
 *
 */
public class ClientUI implements ActionListener , KeyListener{
    private JFrame frame;
    private JTextArea message;
    private JTextArea textField;
    private JList<Object> onlineUsers;
    private JButton send;
    private JButton disconnect;
    private JButton connect;
    private JLabel onlineLabel;
    private JPanel panel;
    private JScrollPane listScroller;
    private JScrollPane messagesByUsers;
    private JScrollPane messagesWrite;
    private Client obj;
    public static JFrame frame2;
    private JTextArea textFieldLogg;
    private JButton signIn;
    private JLabel chatLabel;
    private JPanel panel2;
    private GridBagConstraints c;
    @SuppressWarnings("unused")
    private boolean flag = true;
    private boolean flagConnect = true;
    public static DefaultListModel<Object> listModel;
    private JFrame discon;
    private JFrame errConnection;
    private JFrame alreadyConnected;

    /**
     * Constructor
     */
    public ClientUI()
    {
	//Client GUI
	frame = new JFrame("Omisoft Chat");
	textField = new JTextArea("");
	message = new JTextArea("");
	listModel = new DefaultListModel<Object>();
	
	onlineUsers = new JList<Object>(listModel);// online users list
	
	
	discon = new JFrame("");
	errConnection = new JFrame("");
	alreadyConnected = new JFrame("");
	
	onlineUsers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	onlineUsers.setLayoutOrientation(JList.VERTICAL_WRAP);
	onlineUsers.setVisibleRowCount(-1);
	listScroller = new JScrollPane(onlineUsers);
	messagesByUsers = new JScrollPane(textField);
	

	messagesWrite = new JScrollPane(message);
	send = new JButton("Send");
	disconnect = new JButton("Disconnect");
	connect = new JButton("Connect");
	onlineLabel = new JLabel("Online Users", JLabel.CENTER);
	panel = new JPanel();
	panel.setLayout(null);
	
	
	// Loggin form GUI
	frame2 = new JFrame("Omisoft Chat");
	textFieldLogg = new JTextArea("");
	signIn = new JButton("Sign in");
	chatLabel = new JLabel("Omisoft Chat", JLabel.CENTER);
	panel2 = new JPanel(new GridBagLayout());
	c = new GridBagConstraints();
	
	
	frameClient();	

    }
    
    /**
     * Creating the main frame for the client
     * 
     */
    public void frameClient()
    {
	frame.setSize(900, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setVisible(true);
	textField.setEditable(false);
	
	Font f = textField.getFont();
	Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize()+10);
	onlineLabel.setFont(f2);
	DefaultCaret caret = (DefaultCaret)textField.getCaret();  
	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); 
	
	
	panel.add(messagesByUsers);
	panel.add(messagesWrite);
	panel.add(listScroller);
	panel.add(disconnect);
	panel.add(send);
	panel.add(onlineLabel);
	panel.add(connect);
	
	Insets insets = panel.getInsets();
	
	
	Dimension size = messagesByUsers.getPreferredSize();	
	messagesByUsers.setBounds(5 + insets.left, 5 + insets.top,
		645 + size.width, 450 + size.height);
	
	size = messagesWrite.getPreferredSize();
	messagesWrite.setBounds(5 + insets.left, 475 + insets.top,
		540 + size.width, 75 + size.height);
	
	
	size = listScroller.getPreferredSize();
	listScroller.setBounds(655 + insets.left, 40 + insets.top,
		238 + size.width, 430 + size.height);
	
	
	size = disconnect.getPreferredSize();
	disconnect.setBounds(655 + insets.left, 522 + insets.top,
		128 + size.width, 18 + size.height);
	
	
	size = send.getPreferredSize();
	send.setBounds(550 + insets.left, 475 + insets.top,
		32 + size.width, 65 + size.height);
	
	size = onlineLabel.getPreferredSize();
	onlineLabel.setBounds(585 + insets.left, 5 + insets.top,
		238 + size.width, 5 + size.height);
	
	size = connect.getPreferredSize();
	connect.setBounds(655 + insets.left, 476 + insets.top,
		148 + size.width, 19 + size.height);
	
	
	panel.validate();
	panel.repaint();
	
	frame.add(panel);
	
	frame.validate();
	frame.repaint();
		
		
	send.addActionListener(this);
	connect.addActionListener(this);
	disconnect.addActionListener(this);
	message.addKeyListener(this);	
	
		
    }
    
  
    /**
     * Creating the logging form for the client
     */
    public void frameLoginForm()
    {
	frame2.setSize(400, 220);
	
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.setResizable(false);
	frame2.setVisible(true);
	Font f = textFieldLogg.getFont();
	Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize()+15);
	chatLabel.setFont(f2);
	c.fill = GridBagConstraints.HORIZONTAL;
	
	
	// Adding Label at the top
	
	c.ipadx = 120;
	c.gridx = 0;
	c.gridwidth = 1;
	c.gridy = 0;
	panel2.add(chatLabel, c);
	
	// Adding TextField in the panel

	c.ipady= 5;
	c.insets = new Insets(20,30,20,20);
	c.gridx = 0;
	c.gridy = 1;
	c.anchor = GridBagConstraints.CENTER;
	panel2.add(textFieldLogg, c);
		
	
	// Adding Sign in button at the top

	c.ipady = 20;
	c.gridwidth = 0;
	c.gridx = 0;
	c.gridy = 2;
	panel2.add(signIn, c);	
	
	panel2.validate();
	panel2.repaint();
	
	frame2.add(panel2);
	frame2.validate();
	frame2.repaint();
	
	
	signIn.addActionListener(this);
	
    }

    /**
     * Creating action events to all the buttons in the client application
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();

	
	if (source == connect) 
	{
	    if (flagConnect == true)
	    {
		frameLoginForm();   
		message.setEnabled(false);
		send.setEnabled(false);
		obj = new Client(message, textField, textFieldLogg);
		flagConnect = false;
	    }
	    else
	    {
		JOptionPane.showMessageDialog(alreadyConnected, "You are already connected to Omisoft Chat.", null, JOptionPane.WARNING_MESSAGE);
	    }
	    
	}
	
	if (source == send) 
	{
	    try
	    {
		obj.connectClient();
	    }
	    catch(NullPointerException j)
	    {
		JOptionPane.showMessageDialog(errConnection, "Please connect first !",j.getMessage(), JOptionPane.ERROR_MESSAGE);
	    }
	    
	    message.setText("");
	}
	

	
	if(source == signIn)
	{
	    obj.connectClient();
	    textFieldLogg.setText("");
	    
	    frame2.dispose();
	    
	    message.setEnabled(true);
	    send.setEnabled(true);
	    connect.setEnabled(false);
	   
	}
	
	if(source == disconnect)
	{
	    flagConnect = true;
	    try
	    {
		connect.setEnabled(true);
		obj.setFlag(false);  
		listModel.removeAllElements();
		JOptionPane.showMessageDialog(discon, "You are disconnected from Omisoft Chat.", null, JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	    }
	    catch(NullPointerException l)
	    {
		JOptionPane.showMessageDialog(discon, "You aren't connected to Omisoft Chat.", l.getMessage(), JOptionPane.ERROR_MESSAGE);
	    }
	    catch(ArrayIndexOutOfBoundsException o)
	    {
		// Exception for the JList out of bounds
	    }
	    
	}

    }

    /**
     * Creating action events to the Enter button in the client application
     */
    @Override
    public void keyTyped(KeyEvent e) {
	
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_ENTER)
	{
	    send.doClick();
	}
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_ENTER)
	{
	    message.setText("");
	}	
    }


}
