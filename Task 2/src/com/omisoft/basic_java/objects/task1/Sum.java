package com.omisoft.basic_java.objects.task1;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class Sum
 * @author bkoprinski
 *
 */
public class Sum {
	/**
	 * Sums short numbers
	 * @param a 
	 * @param b
	 */
	public Sum(short a, short b)
	{
		short result = (short) (a+b);
		System.out.println("Short result = " + result);
	}
	/**
	 * Sums integer numbers
	 * @param a
	 * @param b
	 */
	public Sum(int a, int b)
	{
		int result = a+b;
		System.out.println("Integer result = " + result);
		
	}
	/**
	 * Sums float numbers
	 * @param a
	 * @param b
	 */
	public Sum(float a, float b)
	{
		float result = a+b;
		System.out.println("Float result = " + result);
	}
	/**
	 * Sums long numbers
	 * @param a
	 * @param b
	 */
	public Sum(long a, long b)
	{
		long result = a+b;
		System.out.println("Long result = " + result);
	}
	/**
	 * Sums two strings
	 * @param a
	 * @param b
	 */
	public Sum(String a, String b)
	{
		String result = (a)+(b);
		System.out.println("String result = " + result);
	}
	/**
	 * Sums BigInteger numbers
	 * @param a
	 * @param b
	 */
	public Sum(BigInteger a, BigInteger b)
	{
		BigInteger result = a.add(b);
		System.out.println("BigInteger result = " + result);
	}
	/**
	 * Sums BigDecimal numbers
	 * @param a
	 * @param b
	 */
	public Sum(BigDecimal a, BigDecimal b)
	{
		BigDecimal result = a.add(b);
		System.out.println("BigDecimal result = " + result);
	}
	
	
}
