package com.omisoft.basic_java.intro.task3;

public class FindSum {
	/**
	 * Finds the sum
	 * 
	 * @param array
	 * 					main array
	 * @param indexL
	 * 					index from the left of the center of gravity
	 * @param indexR
	 * 					index from the right of the center of gravity
	 * @return	sum
	 */
	public static int findSum(int [] array, int indexL, int indexR) {
		int sum = 0;
		for (int q = indexL; q < indexR; q++) {
			sum += array[q];
		}
		return sum;
	}
}
