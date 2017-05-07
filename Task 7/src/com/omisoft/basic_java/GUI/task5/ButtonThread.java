package com.omisoft.basic_java.GUI.task5;
/**
 * Creating a new thread for the Server button(the GUI application)
 * @author bkoprinski
 *
 */
public class ButtonThread implements Runnable {

    @Override
    public void run() {
	Server obj = new Server();
	obj.startServer();
	
    }

}
