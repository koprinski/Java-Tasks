package com.omisoft.basic_java.DesignPatterns.task7;


/**
 * Creating abstract downloader class
 * @author bkoprinski
 *
 */
public abstract class AbstractDownload {
    public static int one = 1;
    public static int two = 2;
    public static int three = 3;
    public static int four = 4;
    protected int Threshold;
    protected AbstractDownload next;

    /**
     * @param next the next to set
     */
    public void setNext(AbstractDownload next) {
        this.next = next;
    }
    
    /**
     * Method for setting the priority
     * @param msg
     * @param priority
     */
    public void message(String msg, int priority)
    {
    	if (priority <= Threshold) 
    	{
            writeMessage(msg);
    	}
        if (next != null)
        {
            next.message(msg, priority);
        }
    }
    abstract protected String UrlChecking(String link);
    abstract protected void downloadFile(String filename);
    abstract protected void copyFile(String directory);
    abstract protected void writeMessage(String msg);

 
    
}
