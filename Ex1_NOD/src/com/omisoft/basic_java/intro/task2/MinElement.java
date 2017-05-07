package com.omisoft.basic_java.intro.task2;
/**
 * Finds the minimum element of an array
 * 
 * @author bkoprinski
 *
 */
public class MinElement {
	/**
	 * 
	 * @param array
	 * 				main array
	 * @return	min element
	 */
	public static int getMinElement(int [] array) {
		int min = array[0];
		for (int i=1; i<array.length; i++)
		{
			if (min >array[i])
			{
				min =array[i];
			}
		}
		return min;
		
	}
}
