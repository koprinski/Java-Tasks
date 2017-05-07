package com.omisoft.basic_java.intro.task4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 5, 2, 1, 5, 14, 3, 7 };
		
		//Prints all the elements from the array with QuickSort
		System.out.println("QuickSort array elements:");
		int low = 0;
		int high = array.length - 1;
		QuickSortMethod.quickSort(array, low, high);	
		for (int i : array)
		{
			System.out.println(i);
		}
	}

}
