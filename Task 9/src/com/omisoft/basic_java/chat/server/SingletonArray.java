package com.omisoft.basic_java.chat.server;

import java.util.ArrayList;

/**
 * Singleton pattern for keeping all the clients in an list
 * @author bkoprinski
 *
 */
public class SingletonArray {
    private static ArrayList<String> list = new ArrayList<String>();

    /**
     * private constructor
     */
    private SingletonArray(){}
  
    /**
     * Getting the instance to all the clients in the list
     * @return
     */
    public static ArrayList<String> getInstance(){
	return list;
  }
}
