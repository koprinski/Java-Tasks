package com.omisoft.basic_java.intro.task5;

import com.omisoft.basic_java.intro.task2.PrintArray;
/**
 * Tests all the arrays
 * @author bkoprinski
 *
 */
public class Test {
	
	public static void main(String[] args) {
	int[] array = { 5, 2, 1, 5, 14, 3, 7 };
	
	//Prints all the elements from the array backwards
	System.out.println("Reverse array elements:");
	ReverseMethod.reverse(array);
	PrintArray.printArray(array);
	
	
	
	}
}
