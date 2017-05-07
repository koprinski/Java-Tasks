package com.omisoft.basic_java.Collections.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Page bean class
 * @author bkoprinski
 *
 */
public class PageBean {
	private int firstPage;
	private int pageSize;
	private int currentPage;
	private boolean hasNext;  
	private boolean hasPrevious;
	private int totalPage;
	
	private ArrayList<String> list = new ArrayList<String>();
	
	private static Scanner input = null;
	
	
	/**
	 * Constructor of Page Bean
	 */
	public PageBean()
	{
		this.firstPage=1;
		this.currentPage=0;
		this.setHasNext();  
		this.setHasPrevious();
	}
	
	/**
	 * Creating the first page.
	 * @param a - the size of the page
	 * @param elements - number of elements in the list
	 */
	public void firstPage(int a, int elements) 
	{
		
		pageSize = a;
		
		input = new Scanner(System.in);
		String b;

		for (int i = 0; i < elements; i++) {
			System.out.println("Enter element number "+ (i+1) + " : " );
			b = input.next();
			list.add(i, b);
		}
		
		
		for (int i = currentPage; i < pageSize; i++) 
		{
			String index = list.get(i);

			System.out.print(index+ " ");
			
		}
		this.currentPage=1;
		System.out.println();
	

	}
	/**
	 * Getter of the last page
	 */
	public void lastPage()
	{
		this.currentPage=list.size()/pageSize;
		
		for (int i = list.size()-pageSize; i < list.size(); i++) 
		{
			String index = list.get(i);

			System.out.print(index+ " ");
			
		}
		System.out.println();
		
	}
	
	/**
	 * Moving to the next page
	 */
	public void next()
	{
		this.currentPage++;
		this.setHasNext(); 

		try{
		for (int i = (currentPage-1)*pageSize; i <currentPage*pageSize; i++) 
		{
			String index = list.get(i);

			System.out.print(index+ " ");
		}
		System.out.println();
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println();
		}
	}
	/**
	 * Moving to the previous page
	 */
	public void previous()   
    {   
		this.currentPage--;   
		this.setHasNext();   
		this.setHasPrevious();   
		
		try{
		for (int i = (currentPage-1)*pageSize; i <currentPage*pageSize; i++) 
		{
			String index = list.get(i);

			System.out.print(index+ " ");
		}
		System.out.println();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("This is the first page!");
			System.err.println("There arent any previous pages.");
			System.out.println();
		}
    }
	
	/**
	 * @return the firstPage
	 */
	public int getFirstPage() {
		return firstPage;
	}

	/**
	 * @param firstPage the firstPage to set
	 */
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {   
        return currentPage;   
    }   
	/**
	 * @param currentPage the currentPage to set
	 */
    public void setCurrentPage(int currentPage) {   
        this.currentPage = currentPage;   
    }
    
    
    /**
	 * @return the hasNext
	 */
	public boolean isHasNext() {
		return hasNext;
	}


	/**
	 * @param hasNext the hasNext to set
	 */
	public void setHasNext() {

		if (currentPage != totalPage)
		{
			this.hasNext=true;
		}
		else
		{
			this.hasNext=false;
		}
	}
	
	
	/**
	 * @return the hasPrevious
	 */
	public boolean isHasPrevious() {
		return hasPrevious;
	}


	/**
	 * @param hasPrevious the hasPrevious to set
	 */
	public void setHasPrevious() {
		if (currentPage == 1)
		{
			this.hasPrevious=false;
		}
		else
		{
			this.hasPrevious=true;
		}
	}
	/**
	 * Scanner closed
	 */
	public static void scanClose()
	{
		if (input != null)
		{
			input.close();
		}
	}
	
}
