package com.omisoft.basic_java.JDBC.CommonUI;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Creating a common interface for the little pop up frames when choosing
 * a print option
 * @author bkoprinski
 *
 */
public abstract class CommonPrintUI {
    public JFrame frame;
    private JPanel panel;
    public JTextArea textArea;
    public JButton submit;
    public JButton close;
    
    /**
     * Constructor
     */
    public CommonPrintUI()
    {
	frame = new JFrame();
	panel = new JPanel();
	textArea = new JTextArea();
	submit = new JButton("Submit");
	close = new JButton("Close");
    }
    
    /**
     * Initializing the common frames, text areas and buttons
     */
    protected void initUI() 
    {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 200);
	frame.setResizable(false);
	frame.setVisible(true);
	panel.setLayout(null);
	
	
	panel.add(textArea);
	panel.add(submit);
	panel.add(close);
	
	Insets insets = panel.getInsets();
	Dimension size = textArea.getPreferredSize();
	textArea.setBounds(70 + insets.left, 50 + insets.top,
		160 + size.width, 5 + size.height);
	
	size = submit.getPreferredSize();
	submit.setBounds(20 + insets.left, 110 + insets.top,
		40 + size.width, 5 + size.height);
	
	size = close.getPreferredSize();
	close.setBounds(160 + insets.left, 110 + insets.top,
		50 + size.width, 5 + size.height);
	
	panel.validate();
	panel.repaint();

	frame.add(panel);

	frame.validate();
	frame.repaint();
	
    }
    /**
     * Creating abstract class for the specific elements in the pop up frames when choosing
     * a print option
     */
    public abstract void initSpecific();
}
