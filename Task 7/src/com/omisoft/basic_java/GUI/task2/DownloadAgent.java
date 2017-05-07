package com.omisoft.basic_java.GUI.task2;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


/**
 * Logic for the Download Manager
 * @author bkoprinski
 *
 */
public class DownloadAgent {
    private FileOutputStream fos;
    private ByteArrayOutputStream out;
    private InputStream in;
    private JTextField text2 = new JTextField("");
    private JProgressBar downloadPBar= new JProgressBar();
    private JFrame err = new JFrame("");
    
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
        DownloadAgent.flag = flag;
    }

    private static boolean flag = true;
  
    /**
     * Constructor
     * @param text2
     * @param downloadPBar 
     * @param gui 
     */
    public DownloadAgent(JTextField text2, JProgressBar downloadPBar)
    {
	this.text2=text2;
	this.downloadPBar=downloadPBar;
    }
    
    /**
     * Method for downloading a file from the web byte by byte.
     * At first it checks if the URL begins with "http://"
     * @param link
     * @param filename
     */
    public void downloadFile(String link, File filename)
    {

	String http = "http://";
	String a = null;
	try
	{
	    a = link.substring(0, 7);
	}
	catch (StringIndexOutOfBoundsException e)
	{
	    JOptionPane.showMessageDialog(err, "Wrong URL !",e.getMessage(), JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}
	
	if (!a.equals(http))
	{
	    link = http+link;
	}

	try 
	{
	
	    URL linkSave = new URL(link);
	    
	    URLConnection conection = linkSave.openConnection();
	    
            try
            {
        	conection.connect();
            }
            catch (UnknownHostException e)
            {
        	JOptionPane.showMessageDialog(err, "Wrong URL !",e.getMessage(), JOptionPane.ERROR_MESSAGE);
    	    	e.printStackTrace();
            }
	    
            int lenghtOfFile = conection.getContentLength();
	    in = new BufferedInputStream(linkSave.openStream(),8192); // 8k
	    out = new ByteArrayOutputStream();
	    long total = 0;
	  
	    
	    
	    byte[] buf = new byte[1024];
	    int n = 0;
	    while ((-1!=(n=in.read(buf))) && flag)
	    {
		total += n;
		downloadPBar.setValue((int)((total*100)/lenghtOfFile));
		out.write(buf, 0, n);
	    }
	    byte[] response = out.toByteArray();


	    fos = new FileOutputStream(filename);
	    fos.write(response);
	    
	    text2.setText("Download completed!");
	    
	} 
	catch (MalformedURLException e) 
	{
	    e.printStackTrace();
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	}
	
	
	finally
	{
	    try 
	    {
		if (out != null)
		{
		    out.close();
		}
		if (in != null)
		{
		    in.close();
		}
		if (fos != null)
		{
		    fos.close();
		}
		
	    } 
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
		 
	}
    }
}
