package com.omisoft.basic_java.JDBC.CommonUI;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Creating a common interface for the adding frame and updating information frame
 * @author bkoprinski
 *
 */
public abstract class CommonUI {
    public JFrame frame;
    public JTextArea nameText;
    public static JTextArea ageText;
    public JTextArea emailText;
    public JTextArea idText;
    public JTextArea keyText;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel emailLabel;
    private JLabel idLabel;
    private JLabel keyLabel;
    public JButton submit;
    public JButton close;
    private JPanel panel;
    
    /**
     * Constructor
     */
    public CommonUI()
    {
	frame = new JFrame();
	nameText = new JTextArea();
	ageText = new JTextArea();
	emailText = new JTextArea();
	idText = new JTextArea();
	keyText = new JTextArea();
	nameLabel = new JLabel("Name");
	ageLabel = new JLabel("Age");
	emailLabel = new JLabel("Email");
	idLabel = new JLabel("ID");
	keyLabel = new JLabel("Key People");
	submit = new JButton("Submit");
	close = new JButton("Close");
	panel = new JPanel();
    }
    
    /**
     * Initializing the common frames, text areas and buttons
     */
    protected void initUI() 
    {	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400, 350);
	frame.setResizable(false);
	frame.setVisible(true);
	panel.setLayout(null);
	
	
	panel.add(nameLabel);
	panel.add(ageLabel);
	panel.add(emailLabel);
	panel.add(idLabel);
	panel.add(keyLabel);
	panel.add(keyText);
	panel.add(idText);
	panel.add(emailText);
	panel.add(ageText);
	panel.add(nameText);
	panel.add(submit);
	panel.add(close);
	
	Insets insets = panel.getInsets();
	Dimension size = nameLabel.getPreferredSize();
	nameLabel.setBounds(50 + insets.left, 50 + insets.top,
		5 + size.width, 5 + size.height);
	
	size = ageLabel.getPreferredSize();
	ageLabel.setBounds(50 + insets.left, 90 + insets.top,
		5 + size.width, 5 + size.height);
	
	size = emailLabel.getPreferredSize();
	emailLabel.setBounds(50 + insets.left, 130 + insets.top,
		5 + size.width, 5 + size.height);
	
	size = idLabel.getPreferredSize();
	idLabel.setBounds(50 + insets.left, 170 + insets.top,
		5 + size.width, 5 + size.height);
	
	size = keyLabel.getPreferredSize();
	keyLabel.setBounds(50 + insets.left, 210 + insets.top,
		5 + size.width, 5 + size.height);
	
	size = keyText.getPreferredSize();
	keyText.setBounds(180 + insets.left, 210 + insets.top,
		150 + size.width, 5 + size.height);
	
	size = idText.getPreferredSize();
	idText.setBounds(180 + insets.left, 170 + insets.top,
		150 + size.width, 5 + size.height);
	
	size = emailText.getPreferredSize();
	emailText.setBounds(180 + insets.left, 130 + insets.top,
		150 + size.width, 5 + size.height);
	
	size = ageText.getPreferredSize();
	ageText.setBounds(180 + insets.left, 90 + insets.top,
		150 + size.width, 5 + size.height);
	
	size = nameText.getPreferredSize();
	nameText.setBounds(180 + insets.left, 50 + insets.top,
		150 + size.width, 5 + size.height);
	
	size = submit.getPreferredSize();
	submit.setBounds(40 + insets.left, 270 + insets.top,
		50 + size.width, 5 + size.height);
	
	size = close.getPreferredSize();
	close.setBounds(200 + insets.left, 270 + insets.top,
		70 + size.width, 5 + size.height);
	
	panel.validate();
	panel.repaint();

	frame.add(panel);

	frame.validate();
	frame.repaint();
	
	
    }
    
    /**
     * Creating abstract class for the specific elements in separate frames
     */
    public abstract void initSpecific();
}
