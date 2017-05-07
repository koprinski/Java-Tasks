package com.omisoft.basic_java.intro.task3;

public class FindMinSum {
	/**
	 * Finds the minimum sum of the result array and gets its index
	 * 
	 * @param arrayResult
	 * 					array that keeps the subtraction of the left and right sum
	 * @return	index
	 * 						
	 */
	public static int findMinSum(int [] arrayResult)
	{
		int min = arrayResult[0];
		int index = 0;
		for (int i=1; i<arrayResult.length; i++)
		{
			if (min >arrayResult[i])
			{
				min =arrayResult[i];
				index = i;
			}
		}
		return index;
	}
}
