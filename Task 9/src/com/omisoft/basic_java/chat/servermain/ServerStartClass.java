package com.omisoft.basic_java.chat.servermain;

import com.omisoft.basic_java.chat.server.ServerUI;
/**
 * Main class of the server application
 * Starts the program
 * @author bkoprinski
 *
 */
public class ServerStartClass {

    public static void main(String[] args) {
	ServerUI obj = new ServerUI();
	obj.frameServer();

    }

}
