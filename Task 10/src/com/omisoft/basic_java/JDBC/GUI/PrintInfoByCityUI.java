package com.omisoft.basic_java.JDBC.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.omisoft.basic_java.JDBC.CommonUI.CommonPrintUI;
import com.omisoft.basic_java.JDBC.DAO.TableOperationsDAO;

/**
 * Creating print information by city form
 * @author bkoprinski
 *
 */
public class PrintInfoByCityUI extends CommonPrintUI implements ActionListener {

    /**
     * Constructor
     */
    public PrintInfoByCityUI()
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
	    obj1.printInfoByCity(textArea.getText());
	    frame.dispose();
	}
    }

    /**
     * Defining specifications of the frame
     */
    @Override
    public void initSpecific() {
	frame.setTitle("Print People By First City");
	close.addActionListener(this);
	submit.addActionListener(this);
	
    }
}
