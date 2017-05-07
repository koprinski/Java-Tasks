package com.omisoft.basic_java.intro.task2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = { 5, 2, 1, 5, 14, 3, 7 };
		
		// Prints the Minimum element of the array
		int mini = MinElement.getMinElement(array);
		System.out.println("Minimum element from array = " + mini);
		
		//Prints the Sum of the array
		int sum = SumArray.getSum(array);
		System.out.println("Sum of the array = " + sum);
		
		//Prints all the elements from the array
		PrintArray.printArray(array);
	}

}
