package com.omisoft.basic_java.intro.task5;
/**
 * Method for reversing the array backwards
 * @author bkoprinski
 *
 */
public class ReverseMethod {
	/**
	 * @param buf
	 * 				buffer
	 * @param j
	 * 				finds the last element of the array
	 * @param index
	 * 				index of the array
	 * @param array
	 * 				main array
	 */
	public static void reverse (int [] array){
		int buf = 0;
		int j = array.length-1;
		int index = 0;
		if ((array.length % 2)==0){
			index = array.length/2;
		}
		else { index = array.length; }
			
		
		for (int i = 0; i < index; i++) {
			if (i!=j)
			{
			buf = array[i];
			array[i]=array[j];
			array[j] = buf;
			j--;
			}
			else { break; }
			
		}
	}
}
		
