package com.omisoft.basic_java.DesignPatterns.task7;

/**
 * Method for coping the files
 * @author bkoprinski
 *
 */
public class CopyFile extends AbstractDownload{

    /**
     * Constructor
     * @param threshold
     */
    public CopyFile(int threshold)
    {
	this.Threshold = threshold;
    }
    
    /**
     * Checking URL
     */
    @Override
    protected String UrlChecking(String link) {
	return null;
    }

    /**
     * Downloading file
     */
    @Override
    protected void downloadFile(String filename) {
	
    }

    /**
     * Printing message
     */
    @Override
    protected void writeMessage(String msg) {
	System.out.println("Copy file : " + msg);
	
    }

    /**
     * Coping file
     */
    @Override
    protected void copyFile(String directory) {
	
    }
    
}
