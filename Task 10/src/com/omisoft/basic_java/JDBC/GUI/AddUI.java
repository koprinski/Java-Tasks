package com.omisoft.basic_java.JDBC.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.omisoft.basic_java.JDBC.CommonUI.CommonUI;
import com.omisoft.basic_java.JDBC.DAO.TableOperationsDAO;
import com.omisoft.basic_java.JDBC.DTO.GetTableInfoDTO;

/**
 * Creating Adding people information form
 * @author bkoprinski
 *
 */
public class AddUI extends CommonUI implements ActionListener{
    private JFrame success;
    private JFrame err;
    public static boolean flag = true;
    /**
     * @return the flag
     */
    public static boolean isFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public static void setFlag(boolean flag) {
        AddUI.flag = flag;
    }

    /**
     * Constructor
     */
    public AddUI()
    {
	this.initUI();
	this.initSpecific();
	success = new JFrame("Success");
	err = new JFrame("Error");
    }

    /**
     * Defining specifications of the frame
     */
    @Override
    public void initSpecific() {
	frame.setTitle("Add Person In Table");
	
	close.addActionListener(this);
	submit.addActionListener(this);
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
	    try
	    {
		setFlag(true);
		GetTableInfoDTO obj = new GetTableInfoDTO(nameText.getText(),Integer.parseInt(ageText.getText()),emailText.getText(),idText.getText(),Integer.parseInt(keyText.getText()));
		TableOperationsDAO obj1 = new TableOperationsDAO();
		obj1.addToTable(obj);
		nameText.setText("");
		ageText.setText("");
		emailText.setText("");
		idText.setText("");
    	    	keyText.setText("");
	    }
	    catch(NumberFormatException j)
	    {
		setFlag(false);
		JOptionPane.showMessageDialog(err, "Please fill all the text fields.", null, JOptionPane.ERROR_MESSAGE);
		
	    }
	    
	    if(flag)
	    {
		JOptionPane.showMessageDialog(success, "Adding Completed.", null, JOptionPane.INFORMATION_MESSAGE);
	    } 
	    frame.dispose();
	}
    }
    
    
}
