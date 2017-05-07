package com.omisoft.basic_java.JDBC.ServiceLocator;

/**
 * Creating a custom exception for the age validation 
 * @author bkoprinski
 *
 */
public class AgeServiceException extends Exception{
   
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param message
     */
    public AgeServiceException(String message) 
    {
	super(message);
    }
		
    /**
     * Printing a custom message
     */
    public String toString()
    {
	return getMessage()+ " Please write a number between [3,120]. ";
    }
}
