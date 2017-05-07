package com.omisoft.basic_java.DesignPatterns.task7;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

    /**
     * Creating the AbstractDownload chain
     * @return
     */
    private static AbstractDownload createChain() {
	AbstractDownload download1 = new UrlCheck(AbstractDownload.three);
	AbstractDownload download2 = new DownloadFile(AbstractDownload.two);
	download1.setNext(download2);
	AbstractDownload download3 = new CopyFile(AbstractDownload.one);
	download2.setNext(download3);
	
	return download1;
    }
    
    
    public static void main(String[] args) {
	AbstractDownload download = createChain();
	
	download.message("level 1", AbstractDownload.one);
	download.UrlChecking("http://asktuning.com/wp-content/uploads/2011/06/Prior-Design-Bentley-Continental-GT-8.jpg");

	download.message("level 2", AbstractDownload.two);
	download.downloadFile("test");
   
	download.message("level 3", AbstractDownload.three);
	download.copyFile("/home/bkoprinski/dev/bkoprinski/");
	
    
    }

}
