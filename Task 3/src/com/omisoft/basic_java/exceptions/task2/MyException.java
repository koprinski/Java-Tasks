package com.omisoft.basic_java.exceptions.task2;
/**
 * Declaring a custom exception if the number is between [0,100]
 * @author bkoprinski
 *
 */
public class MyException extends Exception {
	
	public MyException(String message) {
        super(message);
    }
	
	public String toString()
	 {
		 return getMessage()+ " Please write a number between [0,100]. ";
	 }
}
