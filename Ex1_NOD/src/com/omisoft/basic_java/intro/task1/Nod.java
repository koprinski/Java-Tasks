package com.omisoft.basic_java.intro.task1;
/**
 * Calculates large common divider
 * @author bkoprinski
 *
 */
public class Nod {
	/**
	 * 
	 * @param a 
	 * 			first int
	 * @param b
	 * 			second int
	 * @return large common divider
	 */
	public static int calculateNod(int a, int b)
	{
		while (a!=b)
		{
			if (a>b)
			{
				a=a-b;
			}
			else 
			{
				b=b-a;
			}
		}
		return a;
	}
}
