package com.omisoft.basic_java.Collections.task2;


import java.util.Scanner;
/**
 * Tests the Page bean program
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter page size: ");
		int size = input.nextInt();
		System.out.println("Enter number of elements: ");
		int elements = input.nextInt();
		
	
		
		PageBean obj = new PageBean();
		obj.firstPage(size, elements);
		int fCase=0;
		
		do{
			
		System.out.println();
		System.out.println("Please choose an option:");
		System.out.println("1 - next page");
		System.out.println("2 - previous page");
		System.out.println("3 - last page");
		System.out.println("4 - current page");
		System.out.println("5 - exit");
		
		fCase = input.nextInt();
		/**
		 * Menu with options
		 */
		switch (fCase) 
		{
			case 1: obj.next(); 
			break;
			case 2: obj.previous();
			break;
			case 3: obj.lastPage();
			break;
			case 4: System.out.println(obj.getCurrentPage());
			break;
			case 5: break;
		}
	}
	while(fCase != 5);
	input.close();
	PageBean.scanClose();
	}
}
