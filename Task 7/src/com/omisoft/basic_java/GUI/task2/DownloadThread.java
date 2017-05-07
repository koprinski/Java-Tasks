package com.omisoft.basic_java.GUI.task2;

import java.io.File;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * Creating thread for the download button which calls the method downloadFile()
 * @author bkoprinski
 *
 */
public class DownloadThread implements Runnable{
    
    private String source;
    private File destination;
    private JTextField text2 = new JTextField("");
    private JProgressBar downloadPBar= new JProgressBar();
    
    /**
     * Constructor of the thread
     * @param source
     * @param destination
     * @param text2
     * @param downloadPBar 
     */
    public DownloadThread(String source, File destination, JTextField text2, JProgressBar downloadPBar)
    {
	this.source=source;
	this.destination=destination;
	this.text2=text2;
	this.downloadPBar=downloadPBar;
    }
    @Override
    public void run() {
	DownloadAgent obj = new DownloadAgent(text2,downloadPBar);
	obj.downloadFile(source, destination);
	
    }

}
