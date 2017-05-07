package com.omisoft.basic_java.JDBC.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.omisoft.basic_java.JDBC.CommonUI.CommonUI;
import com.omisoft.basic_java.JDBC.DAO.TableOperationsDAO;
import com.omisoft.basic_java.JDBC.DTO.GetTableInfoDTO;

/**
 * Creating updating people information form
 * @author bkoprinski
 *
 */
public class UpdateUI extends CommonUI implements ActionListener{
   
    private JFrame success;
    private JFrame err;
    
    /**
     * Constructor
     */
    public UpdateUI()
    {
	this.initUI();
	this.initSpecific();
	success = new JFrame("Success");
	err = new JFrame("Error");
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
		GetTableInfoDTO obj = new GetTableInfoDTO(nameText.getText(),Integer.parseInt(ageText.getText()),emailText.getText(),idText.getText(),Integer.parseInt(keyText.getText()));
		TableOperationsDAO obj1 = new TableOperationsDAO();
		obj1.updateTable(obj);
		nameText.setText("");
		ageText.setText("");
		emailText.setText("");
		idText.setText("");
		keyText.setText("");
		JOptionPane.showMessageDialog(success, "Update Completed.", null, JOptionPane.INFORMATION_MESSAGE);
	    }
	    catch(NumberFormatException h)
	    {
		JOptionPane.showMessageDialog(err, "Please fill all the text fields.", null, JOptionPane.ERROR_MESSAGE);
	    }
	    frame.dispose();
	}
	
    }

    /**
     * Defining specifications of the frame
     */
    @Override
    public void initSpecific() 
    {
	frame.setTitle("Update Person Information In Table");
	
	close.addActionListener(this);
	submit.addActionListener(this);
	
    }

}
