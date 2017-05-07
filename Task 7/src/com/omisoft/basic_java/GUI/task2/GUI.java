package com.omisoft.basic_java.GUI.task2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * Creating the Download Manager application with GUI
 * @author bkoprinski
 *
 */
public class GUI implements ActionListener{
	
	private JFrame frame = new JFrame("Downloader");
	private JButton stop = new JButton("Stop");
	private JButton download = new JButton("Download");
	private JTextField text = new JTextField("Paste the URL here...");
	private JTextField text2 = new JTextField("");
	private JFileChooser choose;
	private JProgressBar downloadPBar= new JProgressBar();

	/**
	 * Forming the frame and adding all the buttons and text fields
	 */
	public void frameDownloader()
	{
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		text.setHorizontalAlignment(JTextField.LEFT);
		text.setName("text");
		download.setName("download");
		stop.setName("stop");
		frame.add(text, BorderLayout.NORTH);
		frame.add(text2,BorderLayout.AFTER_LAST_LINE);
		text2.setEnabled(false);

		JPanel layout = new JPanel();
		layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,6));
	
		
		buttonPanel.add(download);
		buttonPanel.add(stop);

		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setVisible(true);
		
		download.addActionListener(this);
		stop.addActionListener(this);
		choose = new JFileChooser();
		
		
		downloadPBar.setVisible(true);
		buttonPanel.add(downloadPBar);
		downloadPBar.setStringPainted(true);
		frame.repaint();
		
	}
	
	
	/**
	 * Method creating a chooser for saving the file in a particular directory
	 * @param filename 
	 * @param source
	 */
	public void saveInDirectory(File filename, String source)
	{
		
	    choose.setCurrentDirectory(new File("./"));
	    int chooser = choose.showSaveDialog(choose);
	    choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    if ((chooser == JFileChooser.APPROVE_OPTION))
	    {
		File destination = choose.getSelectedFile();
		new Thread(new DownloadThread(source,destination,text2,downloadPBar)).start();
				
	    }
	}


	/**
	 * Method for giving actions to the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	    Object source = e.getSource();

	    if (source == download) 
	    {
		String link = text.getText();
		saveInDirectory(null, link);
		text2.setText("Downloading ...");
		
	    }
	    if (source == stop) 
	    {
		text2.setText("");
		text2.setText("Download is stopped!");
		DownloadAgent.setFlag(false);
	    }
	    
	}
	
	public void showBar(int start, int end)
	{
	    downloadPBar.setMinimum(start);
	    downloadPBar.setMaximum(end);
	    downloadPBar.setValue(start);
	    downloadPBar.setVisible(true);

	}
	
	public void updateBar(int newValue)
	{
	    downloadPBar.setValue(newValue);
	    downloadPBar.setStringPainted(true);
	}


}
