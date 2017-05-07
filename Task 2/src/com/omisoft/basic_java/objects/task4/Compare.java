package com.omisoft.basic_java.objects.task4;

import java.util.Comparator;

public class Compare {
	/**
	 * Compares the two keys.
	 * @param <T>
	 * @param x - first key
	 * @param y - second key
	 * @return - massage if the two keys are equal or not
	 */
	protected <T> int compare(T x, T y) {
        int a = 0;
        /**
    	 * Comparator used to order the items in the tree.
    	 */
    	Comparator<T> comparator = null;
		if (comparator == null) {
        	
            Comparable<T> comparable = (Comparable<T>)x;
			a = comparable.compareTo(y);
            if (a < 0){
            	System.out.println("The two keys arent equal!");
            }
            else if (a==0)
            {
            	System.out.println("The two keys are equal!");
            }
            else
            {
            	System.out.println("The two keys arent equal!");
            }
        } 
		return a;
    }
}
