package com.omisoft.basic_java.intro.task3;
/**
 * Finds the center of gravity
 * @author bkoprinski
 *
 */
public class CenterOfGravity {
	/**
	 * Calculates the center of gravity of an array
	 * 
	 * @param LeftSum
	 * 					first int 
	 * @param RightSum
	 * 					second int
	 * @param array
	 * 					main array
	 * @param arrayResult
	 * 					array that keeps the subtraction of the left and right sum
	 */
	public static void Gravity(int [] array) {
		int LeftSum, RightSum;
		int[] arrayResult = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			LeftSum = FindSum.findSum(array, 0, i);
			RightSum = FindSum.findSum(array, i+1, array.length);
			
			if (LeftSum > RightSum)
			{
				arrayResult[i] = (LeftSum - RightSum);
				
			}
			else if (LeftSum < RightSum)
			{
				arrayResult[i] = RightSum - LeftSum;
			}
			else if (LeftSum == RightSum)
			{
				arrayResult[i] = RightSum;
			}
		//System.out.println("left=" + LeftSum);
		//System.out.println("Right=" + RightSum);
		//System.out.println("Result=" + arrayResult[i]);
		
		
		}
		System.out.println(array[FindMinSum.findMinSum(arrayResult)]);
	}	
}
