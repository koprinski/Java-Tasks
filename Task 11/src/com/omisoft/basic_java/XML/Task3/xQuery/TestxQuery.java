package com.omisoft.basic_java.XML.Task3.xQuery;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class TestxQuery {

    /**
     * Starts the program by opening a connection.
     * The program has a menu from which the user can choose an option and an operation will be executed
     * @param args
     */
    public static void main(String[] args) {
	
	XQDataSource xqs = new SaxonXQDataSource();
	
	XQConnection conn = null;
	XQExpression xqe;
	XQResultSequence rs;
	int fCase = 0;
	Scanner input = null;
	
	try 
	{
	    conn = xqs.getConnection("root", "asdqwe123");
	    xqe = conn.createExpression();
	    input = new Scanner(System.in);
	    
	    do
		{
		    System.out.println("-------------------------------------------------------------------------------");
		    System.out.println("Please choose an option:");
		    System.out.println("1 - Print all the titles ordered by year of publication.");
		    System.out.println("2 - Print the average price of all the books.");
		    System.out.println("3 - Print the titles and the number of authors who wrote the books which cost more than $30.");
		    System.out.println("4 - Print the names of the childen books with upper-case letters and the adult books with lower-case letters.");
		    System.out.println("5 - Print the books with discount.");
		    System.out.println("6 - Exit.");
		    System.out.println("-------------------------------------------------------------------------------");
		    
		    fCase = input.nextInt();
		    
		    switch (fCase) 
		    {
		    	case 1: rs = xqe.executeQuery(Query.SORT_BY_YEAR);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
			break;
			
		    	case 2: rs = xqe.executeQuery(Query.AVG_PRICE);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
	        	break;
		    	
		    	case 3: rs = xqe.executeQuery(Query.NAME_COUNT_AUTHORS);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
	        	break;
	        	
		    	case 4: rs = xqe.executeQuery(Query.CHILD_TITLE_LETTER_CASE);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
		    	break;
		    	
		    	case 5: rs = xqe.executeQuery(Query.DISCOUNT_BOOK_TITLES);
	        	    	while(rs.next())
	        		{
	        		     System.out.println(rs.getItemAsString(null));
	        		}
		    	break;
		    	case 6: break;
		    }
		}
		while(fCase != 6);
	    
	}
	catch (XQException e) 
	{
	    e.printStackTrace();
	}
	catch(InputMismatchException j)
	{
	    System.err.println("Please write an integer value.");
	}
	finally
	{
	    if(conn != null)
	    {
		try 
		{
		    conn.close();
		}
		catch (XQException e)
		{
		    e.printStackTrace();
		}
	    }
	    if(input != null)
	    {
		input.close();
	    }
	}
	
    }

}
