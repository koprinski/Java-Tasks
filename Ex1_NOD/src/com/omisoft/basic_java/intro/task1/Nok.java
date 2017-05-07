package com.omisoft.basic_java.intro.task1;


/**
 * Calculates least common multiple
 * @author bkoprinski
 *
 */
public class Nok {
	/**
	 * 
	 * @param a
	 * 			first int
	 * @param b
	 * 			second int
	 * @return	least common multiple
	 */
	public static int calculateNok(int a, int b)
	{
		return (a/Nod.calculateNod(a, b))*b;
	}
}
