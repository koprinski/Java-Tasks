package com.omisoft.basic_java.exceptions.task3;
/**
 * Declaring a custom exception if the list is already full
 * @author bkoprinski
 *
 */
public class AlreadyFullException extends Exception {
	public AlreadyFullException(String message) {
        super(message);
    }
	
	public String toString()
	 {
		 return getMessage()+ "\nThe list is already full!";
	 }
}
