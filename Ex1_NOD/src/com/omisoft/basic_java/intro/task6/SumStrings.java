package com.omisoft.basic_java.intro.task6;
/**
 * Sums two random numbers with strings
 * @author bkoprinski
 *
 */
public class SumStrings {
	/**
	 * 
	 * @param a
	 * 			first string
	 * @param b
	 * 			second string
	 * @param a1
	 * 			char that keeps the last element of the first string
	 * @param b1
	 * 			char that keeps the last element of the second string
	 * @param a2
	 * 			for converting a char to int
	 * @param b2
	 * 			for converting a char to int
	 * @param sum
	 * 			sum of the two numbers and the onmind number
	 * @param onmind
	 * 			int that keeps the onmind number
	 * @return c
	 * 			String with the calculated sum
	 */
	public static String sumString(String a, String b)
	{
		char a1, b1;
		int a2, b2, sum, onmind = 0;
		String c = "";
		String d = "";
		
		
		while (a.length()>0 || b.length()>0)
		{
			if (a.length()>0)
			{
				a1 = a.charAt(a.length()-1); // finds the last symbol of the string 1
				a = a.substring(0, a.length()-1); // writes in a everything from the beginning to length()-1
			}
			else {a1 = '0';}
			if (b.length()>0)
            {
                b1 = b.charAt(b.length()-1); // finds the last symbol of the string 2
                b = b.substring(0, b.length()-1); // writes in b everything from the beginning to length()-1
            }
            else {b1 = '0';}
			a2 = (int) (a1 - '0');
			b2 = (int) (b1 - '0');
			sum = a2 + b2 + onmind;
			
			if (sum > 9)
			{
				onmind = sum;
				sum = sum - 10;
			}
			onmind = onmind / 10;
			
			c = sum + c;
			
		}
		if (onmind == 0)
		{
			d = "";
		}
		else
		{
			d = ""+ onmind;
		}
		return d + c;
		
	}

}





	    
	  
	
