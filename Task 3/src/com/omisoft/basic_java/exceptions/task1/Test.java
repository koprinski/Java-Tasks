package com.omisoft.basic_java.exceptions.task1;

import java.util.Scanner;

/**
 * Tests the sum of the two strings
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("First string = " );
		String first = input.next();
		System.out.print("Second string = " );
		String second = input.next();
		SumStrings.sum(first, second);
		input.close();
		
	}

}
