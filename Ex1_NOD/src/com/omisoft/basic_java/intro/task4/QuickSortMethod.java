package com.omisoft.basic_java.intro.task4;
/**
 * Quick sort method
 * @author bkoprinski
 *
 */
public class QuickSortMethod {
	/**
	 * 
	 * @param array
	 * 				main array
	 * @param low
	 * 				first int that shows the lower number
	 * @param high
	 * 				second int that shows the higher number
	 * @param pivot
	 * 				finds the middle number from the array(pivot)
	 * @param temp
	 * 				int keeps the array on the left side(low)
	 *
	 */
	public static void quickSort (int array [], int low, int high)
	{
		
		int i = low;
		int j = high;
		
		int pivot = array[(low + high)/2];
		
		
		
		while (low < high) {
			
			while (array[low] < pivot) {
			        low++;
			      }
			
			while (array[high] > pivot) {
		        high--;
		      }
			
			if (low <= high) {
				
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			    low++;
			    high--;
			}
		}
		
		if (i < high)
		{
			quickSort(array, i, high);
		}
			
		if (low < j){
		    quickSort(array, low, j);
		}
		    	
		  }
	
}
