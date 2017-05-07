package com.omisoft.basic_java.JDBC.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creating a base dao for keeping the sql server properties
 * @author bkoprinski
 *
 */
public abstract class BaseDAO {
    
    private static final String PROPERTY_URL = "jdbc:mysql://localhost/Task2";
    private static final String PROPERTY_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PROPERTY_USERNAME = "root";
    private static final String PROPERTY_PASSWORD = "asdqwe123";
    public static Connection connect;
    public PreparedStatement statement;
   
    /**
     * Method for opening a connection to the sql server
     * @throws Exception
     */
    public void connection() throws Exception
    {
	Class.forName(PROPERTY_DRIVER);
	connect = DriverManager.getConnection(PROPERTY_URL,PROPERTY_USERNAME,PROPERTY_PASSWORD);

    }
    
    /**
     * Method for closing the connection to the sql server
     */
    public void closeConnection() 
    {
            try 
            {
        	connect.close();
	    } 
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }

    }
    
    /**
     * Closing the PreparedStatement
     */
    public void closeStatement()
    {
	try 
        {
    	if(statement != null)
    	{
    	    statement.close();
    	}
		
	    }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

}
