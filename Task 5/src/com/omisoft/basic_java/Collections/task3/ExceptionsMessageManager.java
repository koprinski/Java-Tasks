package com.omisoft.basic_java.Collections.task3;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/**
 * Exceptions Message Manager
 * @author bkoprinski
 *
 */
public class ExceptionsMessageManager {
	
	 public static Hashtable<String, String> exceptions = new Hashtable<String, String>();
	 
	 private static String message = "";
	 
	 private static String separator = "-";
	 
	 /**
	  * Adding exception messages and codes in the hashtable
	  */
	 public static void exceptions()
	 
	 {
		 exceptions.put("1", "Wrong postal code");
		 exceptions.put("2", "Wrong debit card number");
		 exceptions.put("3", "Wrong operation");
	 }
	 /**
	  * Checking if the exception message exists in the hashtable 
	  * if yes we are adding it in the string message
	  * if not we are printing error message
	  * 
	  * @param mess - new exception message
	  * 
	  */
	 public static void addExceptionMessage(String mess)
	 {
		 exceptions();
		 
		 boolean exist = exceptions.contains(mess);
		 
		 if (exist==true)
		 {
			 if (message == "")
			 {
				 message = mess + separator;
			 }
			 else
			 {
				 message = message + mess + separator;
			 }
			 System.out.println("The exception is saved!");
		 }
		 else
		 {
			 System.err.println("The exception message is not defined in the exceptions!");
		 }
	 }
	 /**
	  * Checking if the exception message code exists in the hashtable 
	  * if yes we are adding the exception message in the string message
	  * if not we are printing error message
	  * 
	  * @param messageCode - new exception message code
	  */
	 public static void addExceptionMessageUsingCode(String messageCode)
	 {
		 exceptions();
		 
		 boolean exist = exceptions.containsKey(messageCode);
		 
		 if (exist==true)
		 {
			 if (message == "")
			 {
				 message = exceptions.get(messageCode)+separator;
			 }
			 else
			 {
				 message = message + exceptions.get(messageCode) + separator;
			 }
			 
			 System.out.println("The exception is saved!");
		 }
		 else
		 {
			 System.err.println("The exception message code is not defined in the exceptions!");
		 }
		 
	 }
	 
	 /**
	  * Gets the value of message
	  */
	 public static void getMessage()
	 {
		 System.out.println(message);
	 }
	 
	 /**
	  * Finds the separator in the message
	  * @return - List of strings with the exception messages
	  */
	 public static List<String> getMessages()
	 {
		 List<String> arr = new ArrayList<String>();

		
		 String[] t = message.split(separator);
		
		 for (int i = 0; i < t.length; i++) {
			 arr.add(t[i]);
		 }
		 return arr;
	}
	
}
