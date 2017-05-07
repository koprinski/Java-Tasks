package com.omisoft.basic_java.GUI.task4;
/**
 * Creating a new thread for the Server button(the GUI application)
 * @author bkoprinski
 *
 */
public class ServerThread implements Runnable {

	
    @Override
    public void run()
    {
	Server obj = new Server();
	obj.connect();
    }

}
