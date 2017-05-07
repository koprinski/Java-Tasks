package com.omisoft.basic_java.JDBC.GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.omisoft.basic_java.JDBC.DAO.TableOperationsDAO;

/**
 * Creating a main form for choosing an operation
 * @author bkoprinski
 *
 */
public class MainGUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    public static JTextArea textArea;
    private JScrollPane list;
    private JButton add;
    private JButton update;
    private JButton print;
    private JButton printBySymbol;
    private JButton printByCity;
    private JButton printOrderedCity;
    private JButton deleteTableContent;
    private JButton deleteTable;
    
    /**
     * Constructor
     */
    public MainGUI()
    {
	frame = new JFrame("People Information");
	panel = new JPanel();
	textArea = new JTextArea();
	add = new JButton("Add Person");
	update = new JButton("Update Info");
	print = new JButton("Print Info");
	printBySymbol = new JButton("Print By Symbol");
	printByCity = new JButton("Print By City");
	printOrderedCity = new JButton("Print Ordered City");
	deleteTableContent = new JButton("Delete Table Info");
	deleteTable = new JButton("Delete Table");
	list = new JScrollPane(textArea);
	start();
    }
    
    /**
     * Method for defining frame size and the layout of the form
     */
    public void start()
    {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800, 530);
	frame.setResizable(false);
	frame.setVisible(true);
	panel.setLayout(null);
	textArea.setEditable(false);
	
	panel.add(list);
	panel.add(add);
	panel.add(update);
	panel.add(print);
	panel.add(printBySymbol);
	panel.add(printByCity);
	panel.add(printOrderedCity);
	panel.add(deleteTableContent);
	panel.add(deleteTable);
	
	Insets insets = panel.getInsets();
	Dimension size = list.getPreferredSize();
	list.setBounds(200 + insets.left, 2 + insets.top,
		598 + size.width, 510 + size.height);
	
	size = add.getPreferredSize();
	add.setBounds(2 + insets.left, 2 + insets.top,
		82 + size.width, 40 + size.height);
	
	size = update.getPreferredSize();
	update.setBounds(2 + insets.left, 68 + insets.top,
		80 + size.width, 40 + size.height);
	
	size = print.getPreferredSize();
	print.setBounds(2 + insets.left, 134 + insets.top,
		98 + size.width, 40 + size.height);
	
	size = printBySymbol.getPreferredSize();
	printBySymbol.setBounds(2 + insets.left, 200 + insets.top,
		53 + size.width, 40 + size.height);
	
	size = printByCity.getPreferredSize();
	printByCity.setBounds(2 + insets.left, 266 + insets.top,
		77 + size.width, 40 + size.height);
	
	size = printOrderedCity.getPreferredSize();
	printOrderedCity.setBounds(2 + insets.left, 332 + insets.top,
		35 + size.width, 40 + size.height);
	
	size = deleteTableContent.getPreferredSize();
	deleteTableContent.setBounds(2 + insets.left, 398 + insets.top,
		42 + size.width, 40 + size.height);
	
	size = deleteTable.getPreferredSize();
	deleteTable.setBounds(2 + insets.left, 464 + insets.top,
		73 + size.width, 40 + size.height);
	
	panel.validate();
	panel.repaint();

	frame.add(panel);

	frame.validate();
	frame.repaint();
	
	add.addActionListener(this);
	update.addActionListener(this);
	print.addActionListener(this);
	printBySymbol.addActionListener(this);
	printByCity.addActionListener(this);
	printOrderedCity.addActionListener(this);
	deleteTableContent.addActionListener(this);
	deleteTable.addActionListener(this);
    }

    /**
     * Giving actions to the form buttons and text field
     */
    @SuppressWarnings("unused")
    @Override
    public void actionPerformed(ActionEvent e)
    {
	Object source = e.getSource();
	
	TableOperationsDAO obj1 = new TableOperationsDAO();
	
	if(source.equals(add))
	{
	    AddUI obj = new AddUI();
	}
	if(source.equals(update))
	{
	    UpdateUI obj = new UpdateUI();
	}
	if(source.equals(print))
	{
	    obj1.printTable();
	}
	if(source.equals(printBySymbol))
	{
	    PrintPeopleUI obj = new PrintPeopleUI();
	}
	if(source.equals(printByCity))
	{
	    PrintInfoByCityUI obj = new PrintInfoByCityUI();
	}
	if(source.equals(printOrderedCity))
	{
	    obj1.printOrderedCity();
	}
	if(source.equals(deleteTableContent))
	{
	    DeleteTableContentUI obj = new DeleteTableContentUI();
	}
	if(source.equals(deleteTable))
	{
	    DeleteTableUI obj = new DeleteTableUI();
	}
    }
}
