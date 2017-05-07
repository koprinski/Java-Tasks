package com.omisoft.basic_java.DesignPatterns.task7;


/**
 * Method for downloading a file
 * @author bkoprinski
 *
 */
public class DownloadFile extends AbstractDownload{

    @SuppressWarnings("unused")
    private String linkFinal;
    
    /**
     * Constructor
     * @param threshold
     */
    public DownloadFile(int threshold)
    {
	this.Threshold = threshold;
    }
    
    /**
     * Printing message
     */
    @Override
    protected void writeMessage(String msg) {
	System.out.println("Download file : " + msg);
	
    }

    /**
     * Checking URL
     */
    @Override
    protected String UrlChecking(String link) {
	
	return linkFinal = link;
    }

    /**
     * Downloading file
     */
    @Override
    protected void downloadFile(String filename) {

    }

    /**
     * Coping file
     */
    @Override
    protected void copyFile(String directory) {
	
    }

}
