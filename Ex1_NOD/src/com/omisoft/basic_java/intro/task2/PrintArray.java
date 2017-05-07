package com.omisoft.basic_java.intro.task2;

public class PrintArray {
	/**
	 * Prints the elements of the array
	 * @param array
	 * 				main array
	 */
	public static void printArray(int [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Array[" + i + "] = " + array[i]);	
		}
	}
}
