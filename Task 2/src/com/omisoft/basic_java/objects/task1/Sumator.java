package com.omisoft.basic_java.objects.task1;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Tests the Sumator for the different methods
 * @author bkoprinski
 *
 */
public class Sumator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Sum intSum = new Sum(327682, 327682);
		Sum floatSum = new Sum (2.3f, 3.2f);
		Sum longSum = new Sum(72036854775808l ,72036854775808l);
		Sum shortSum = new Sum((short)32700,(short)66);
		Sum stringSum = new Sum("21","23");
		Sum bigInteger  = new Sum(BigInteger.valueOf(153544212),BigInteger.valueOf(2132434342));
		Sum bigDecimal = new Sum(BigDecimal.valueOf(1.35312545),BigDecimal.valueOf(0.4154546414564623));
		
	}
	
}
