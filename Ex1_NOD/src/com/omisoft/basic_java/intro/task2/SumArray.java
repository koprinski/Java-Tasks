package com.omisoft.basic_java.intro.task2;
/**
 * Sums all the elements of an array
 * @author bkoprinski
 *
 */
public class SumArray {
	/**
	 * Finds the sum
	 * @param array
	 * 				main array
	 * @return	sum
	 */
	public static int getSum(int [] array) {
		int sum = 0;
		for (int i=0; i<array.length; i++)
		{
			sum += array[i];
		}
		return sum;
	}
}
