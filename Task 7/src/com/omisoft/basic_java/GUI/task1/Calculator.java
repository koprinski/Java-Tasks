package com.omisoft.basic_java.GUI.task1;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * Creating a Calculator application with GUI
 * @author bkoprinski
 *
 */
public class Calculator implements ActionListener {
	
	private JFrame frame = new JFrame("Calculator");
	private JTextArea text = new JTextArea("");
	private JButton but0 = new JButton("0");
	private JButton but1 = new JButton("1");
	private JButton but2 = new JButton("2");
	private JButton but3 = new JButton("3");
	private JButton but4 = new JButton("4");
	private JButton but5 = new JButton("5");
	private JButton but6 = new JButton("6");
	private JButton but7 = new JButton("7");
	private JButton but8 = new JButton("8");
	private JButton but9 = new JButton("9");
	
	private JButton butsum = new JButton("+");
	private JButton butsub = new JButton("-");
	private JButton butdiv = new JButton("/");
	private JButton butmulti = new JButton("*");
	private JButton butequal = new JButton("=");
	private JButton butdel = new JButton("C");
	private JButton butdelone = new JButton("<-");
	private JFrame err = new JFrame("");
	
	private double numbA, numbB, result;
	private int sum=0,sub=0,div=0,multi=0;

	
	/**
	 * Creating the Calculator layout and adding the buttons in a grid
	 */
	public void frameCalc()
	{
		
		frame.setSize(250, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		text.setEditable(false);
		
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 4));        
		frame.add(text, BorderLayout.NORTH);
		text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		buttonPanel.add(but7);
		buttonPanel.add(but8);
		buttonPanel.add(but9);
		buttonPanel.add(butdiv);
		buttonPanel.add(but4);
		buttonPanel.add(but5);
		buttonPanel.add(but6);
		buttonPanel.add(butmulti);
		buttonPanel.add(but1);
		buttonPanel.add(but2);
		buttonPanel.add(but3);
		buttonPanel.add(butsub);
		buttonPanel.add(but0);
		buttonPanel.add(butdelone);
		buttonPanel.add(butdel);
		buttonPanel.add(butsum);

		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.add(butequal,BorderLayout.SOUTH);
		frame.repaint();
		
		but0.addActionListener(this);
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		but6.addActionListener(this);
		but7.addActionListener(this);
		but8.addActionListener(this);
		but9.addActionListener(this);
		butsum.addActionListener(this);
		butsub.addActionListener(this);
		butdiv.addActionListener(this);
		butmulti.addActionListener(this);
		butequal.addActionListener(this);
		butdel.addActionListener(this);
		butdelone.addActionListener(this);

	}
	/**
	 * Method for giving actions to the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	    if (e.getSource() instanceof JButton)
	    {
		JButton clickedButton = (JButton) e.getSource();
		String buttonText = clickedButton.getText();
		if (clickedButton.equals(but0) || clickedButton.equals(but1) || clickedButton.equals(but2) || clickedButton.equals(but3) || clickedButton.equals(but4) || clickedButton.equals(but5) || clickedButton.equals(but6) || clickedButton.equals(but7) || clickedButton.equals(but8) || clickedButton.equals(but9))
	        {
		    
		    if(text.getText().equals("0"))
		    {
			text.setText("0");
		    }
		    else
		    {
			text.append(buttonText);
		    }
	        }
	        if (clickedButton.equals(butsum))
		{
	            numbA = readNumb();  
	            text.setText("");	
	            sum=1;
	            sub=0;
	            div=0;
	            multi=0;
		}
		else if (clickedButton.equals(butsub))
		{
		    numbA = readNumb();
		    text.setText("");	    
		    sum=0;
		    sub=1;
		    div=0;
		    multi=0;
		}
		else if (clickedButton.equals(butdiv))
		{
		    numbA = readNumb();
		    text.setText("");
		    sum=0;
		    sub=0;
		    div=1;
		    multi=0;
		}
		else if (clickedButton.equals(butmulti))
		{
		    numbA = readNumb();
		    text.setText("");
		    sum=0;
		    sub=0;
		    div=0;
		    multi=1;
		}
	            
	        if (clickedButton.equals(butequal))
		{
	            numbB = readNumb();
	            text.setText("");
	            if (sum>0)
	            {
	        	text.setText("");
	        	result = numbA + numbB;
	        	text.setText(Double.toString(result));
	            }
	            else if (sub>0)
	            {
	        	text.setText("");
	        	result = numbA - numbB;
	        	text.setText(Double.toString(result));
	            }
	            else if (div>0)
	            {
	        	text.setText("");
	        	if (numbB == 0)
	        	{
	        	    text.setText("Division by zero is undefined");
	        	}
	        	else
	        	{
	        	    result = numbA / numbB;
	        	    text.setText(Double.toString(result));
	        	}
	        	
	            }
	            else if (multi>0)
	            {
	        	text.setText("");
	        	result = numbA * numbB;
	        	text.setText(Double.toString(result));
	            }	
		}
	        if (clickedButton.equals(butdel))
		{
	            numbA=0;
	            numbB=0;
	            text.setText("");
		}
		if (clickedButton.equals(butdelone))
		{
		    String str;
		    str = text.getText().toString();
		    str = str.substring(0, str.length()-1);
		    text.setText(str);
		}
	            
	    }
	}
	        
	
	/**
	 * Method for reading the numbers from the TestArea
	 * @return - the actual number
	 */
	public double readNumb()
	{
	    	double number = 0;
		String str;
		str = text.getText();
		
		try
		{
		    number = Double.valueOf(str);
		}
		catch(NumberFormatException e)
		{
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(err, "Please write a number in the text field !",e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		

		return number;
		
	}
	
	
}
