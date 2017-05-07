package com.omisoft.basic_java.DesignPatterns.task7;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;


public class UrlCheck extends AbstractDownload{

    private FileOutputStream fos;
    private ByteArrayOutputStream out;
    private InputStream in;
    private String linkFinal;
    
    /**
     * Constructor
     * @param threshold
     */
    public UrlCheck(int threshold)
    {
	this.Threshold = threshold;
    }
    
    /**
     * Method for checking the url
     * @author bkoprinski
     *
     */
    protected String UrlChecking(String link)
    {

	String http = "http://";
	String a = link.substring(0, 7);
	if (!a.equals(http))
	{
	    link = http+link;
	}
	linkFinal = link;
	return linkFinal;
    }
    
    /**
     * Printing message
     */
    @Override
    protected void writeMessage(String msg) {
	System.out.println("URL check : " + msg);
	
    }

    /**
     * downloading file
     */
    @Override
    protected void downloadFile(String filename) {
	try 
	{
	    URL linkSave = new URL(linkFinal);
	    System.out.println("The file is downloaded.");
	    URLConnection conection = linkSave.openConnection();
	    conection.connect();

	    in = new BufferedInputStream(linkSave.openStream());
	    out = new ByteArrayOutputStream();
	      
	    
	    byte[] buf = new byte[1024];
	    int n = 0;
	    while ((-1!=(n=in.read(buf))))
	    {	
		out.write(buf, 0, n);
	    }
	    byte[] response = out.toByteArray();


	    fos = new FileOutputStream(filename);
	    fos.write(response);
	    
	    
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
		out.close();
		in.close();
		fos.close();
	    } 
	    catch (IOException e)
	    {
		e.printStackTrace();
	    }
		 
	}
	
    }

    /**
     * Coping file
     */
    @Override
    protected void copyFile(String directory) {
	String source = "/home/bkoprinski/dev/bkoprinski/Task 8/test";
	
	
	File sourceFile = new File(source);
	String name = sourceFile.getName();
	File targetFile = new File(directory+name);
	System.out.println("Copying file : " + sourceFile.getName() +" from /home/bkoprinski/dev/bkoprinski/Task 8/");

	Path from = Paths.get(source);
	Path to = targetFile.toPath();
	try 
	{
	    Files.copy(from, to, REPLACE_EXISTING);
	} 
	catch (IOException e) 
	{
	    e.printStackTrace();
	}
	
    }

}
