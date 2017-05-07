package com.omisoft.basic_java.JDBC.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.omisoft.basic_java.JDBC.CommonUI.CommonPrintUI;
import com.omisoft.basic_java.JDBC.DAO.TableOperationsDAO;
import com.omisoft.basic_java.JDBC.DTO.GetTableInfoDTO;

/**
 * Creating delete table contents form
 * @author bkoprinski
 *
 */
public class DeleteTableContentUI extends CommonPrintUI implements ActionListener {

    private GetTableInfoDTO obj = new GetTableInfoDTO(null, 0, null, null, 0);
    private JFrame success;
    
    /**
     * Constructor
     */
    public DeleteTableContentUI()
    {
	this.initUI();
	this.initSpecific();
	success = new JFrame("Success");
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
	    obj.setTable(textArea.getText());
	    obj1.deleteTableContent(obj);
	    JOptionPane.showMessageDialog(success, textArea.getText() +" Contents Deleted.", null, JOptionPane.INFORMATION_MESSAGE);
	    frame.dispose();
	}
	
    }

    /**
     * Defining specifications of the frame
     */
    @Override
    public void initSpecific()
    {
	frame.setTitle("Delete Table Content");
	close.addActionListener(this);
	submit.addActionListener(this);
	
    }

}
