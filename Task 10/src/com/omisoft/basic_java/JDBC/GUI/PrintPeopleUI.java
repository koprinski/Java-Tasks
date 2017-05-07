package com.omisoft.basic_java.JDBC.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.omisoft.basic_java.JDBC.CommonUI.CommonPrintUI;
import com.omisoft.basic_java.JDBC.DAO.TableOperationsDAO;

/**
 * Creating print people information by first symbol form
 * @author bkoprinski
 *
 */
public class PrintPeopleUI extends CommonPrintUI implements ActionListener{

    /**
     * Constructor
     */
    public PrintPeopleUI()
    {
	this.initUI();
	this.initSpecific();
    }
    
    /**
     * Giving actions to the form buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
	Object source = e.getSource();
	
	if(source.equals(close))
	{
	    frame.dispose();
	}
	if(source.equals(submit))
	{
	    TableOperationsDAO obj1 = new TableOperationsDAO();
	    obj1.printPeopleStartSymbol(textArea.getText());
	    frame.dispose();
	}
    }

    /**
     * Defining specifications of the frame
     */
    @Override
    public void initSpecific() {
	frame.setTitle("Print People By First Letter");
	close.addActionListener(this);
	submit.addActionListener(this);
	
    }
}
