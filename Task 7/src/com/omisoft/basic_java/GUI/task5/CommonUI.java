package com.omisoft.basic_java.GUI.task5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creating a common interface for the client and server application
 * @author bkoprinski
 *
 */
public abstract class CommonUI {
    public JPanel layout = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JFrame frame = new JFrame("Server-Client Manager");
   
    /**
     * Initializing the common frames and text areas
     */
    protected void init() {
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 250);
	JPanel layout = new JPanel();
	layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new GridLayout(5, 5));
	frame.add(buttonPanel, BorderLayout.CENTER);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
	frame.repaint();
    }

    /**
     * Creating abstract class for the specific elements in the client and server application
     */
    public abstract void initSpecific();
}
