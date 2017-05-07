package com.omisoft.basic_java.exceptions.task1;

public class SumStrings {
	/**
	 * Sums two strings written from the keyboard
	 * @param a - first string
	 * @param b - second string
	 * @throws NumberFormatException - exception if the two strings arent integer
	 */
	public static int sum(String a, String b) throws NumberFormatException, IndexOutOfBoundsException {
		int x = 0;
	    int y = 0;
		int z = 0;

		try{
			x=Integer.parseInt(a); 
			y=Integer.parseInt(b); 
			z = x+y;   
			System.out.println("SumString:");
			System.out.println(z);
	    }
	    catch(NumberFormatException e)
	    {
	    	System.err.println("\nError!\n");
	    	System.err.println("Please write two integer strings!");
	    	e.printStackTrace();
	    }
		return z;
		
	}
	
}
