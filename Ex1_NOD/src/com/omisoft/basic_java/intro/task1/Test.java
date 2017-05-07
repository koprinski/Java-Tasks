package com.omisoft.basic_java.intro.task1;


/**
 * Tests NOD and NOK calculation
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 13;
		int b = 1;
		int result = Nod.calculateNod(a, b);
		int result1 = Nok.calculateNok(a, b);

		System.out.println(result);
		System.out.println(result1);
	}
}
	


