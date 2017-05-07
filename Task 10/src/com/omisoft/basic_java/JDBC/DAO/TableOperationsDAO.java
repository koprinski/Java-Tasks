package com.omisoft.basic_java.JDBC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.omisoft.basic_java.JDBC.DTO.GetTableInfoDTO;
import com.omisoft.basic_java.JDBC.DTO.Query;
import com.omisoft.basic_java.JDBC.GUI.AddUI;
import com.omisoft.basic_java.JDBC.GUI.MainGUI;
import com.omisoft.basic_java.JDBC.ServiceLocator.AgeServiceException;
import com.omisoft.basic_java.JDBC.ServiceLocator.ValidateAgeService;


/**
 * Creating a class with table operation methods
 * @author bkoprinski
 *
 */
public class TableOperationsDAO extends BaseDAO implements TableDAO {
    private ResultSet rs;
    private ValidateAgeService objValidateAge;
    private JFrame err;
    
    /**
     * Constructor
     */
    public TableOperationsDAO()
    {
	objValidateAge = new ValidateAgeService();
	err = new JFrame("Age Validation");
	try 
	{
	    this.connection();
	} 
	catch (Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    /**
     * Adding into table
     */
    @Override
    public void addToTable(GetTableInfoDTO dto) 
    {
	
        try 
        {	
     
            statement = connect.prepareStatement(Query.ADD_TO_TABLE_QUERY + 
	    	"VALUES(?,?,?,?,?)");
	    
            statement.setString(1, dto.getName());
            try
            {
        	AddUI.setFlag(true);
        	statement.setInt(2, objValidateAge.validateAge());
            }
            catch(AgeServiceException e)
            {
        	// Age validation exception
        	AddUI.setFlag(false);
        	JOptionPane.showMessageDialog(err, "Please write a number between [3,120].", null, JOptionPane.ERROR_MESSAGE);
            }
            statement.setString(3, dto.getEmail());
            statement.setString(4, dto.getID());
            statement.setInt(5, dto.getKeyPeople());
	    
            statement.executeUpdate();
	    
	    System.out.println("Adding Completed.");
	}
        catch (SQLException e) 
        {
	    e.printStackTrace();
	}
        finally
        {
            closeConnection();
            closeStatement();
        }
    }

    /**
     * Updating table information
     */
    @Override
    public void updateTable(GetTableInfoDTO dto) 
    {
	try 
	{
	    statement = connect.prepareStatement(Query.UPDATE_TABLE_QUERY);
	    
	    statement.setString(1, dto.getName());
	    statement.setInt(2, dto.getAge());
	    statement.setString(3, dto.getEmail());
	    statement.setString(4, dto.getID());
	    statement.setInt(5, dto.getKeyPeople());
	    statement.setString(6, dto.getID());
	    
	    statement.executeUpdate();
	    
	    System.out.println("Update Completed.");
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
	}
	
    }

    /**
     * Printing table information
     */
    @Override
    public void printTable() 
    {
	try 
	{
	    statement = connect.prepareStatement(Query.PRINT_TABLE_QUERY);
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    while (rs.next()) 
	    {
		String name = rs.getObject(1).toString();
		String age = rs.getObject(2).toString();
		String email = rs.getObject(3).toString();
		String id = rs.getObject(4).toString();
		MainGUI.textArea.append("\nName   : " + name);
		MainGUI.textArea.append("\nAge    : " + age );
		MainGUI.textArea.append("\nEmail  : " + email );
		MainGUI.textArea.append("\nID     : " + id );
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
            try 
            {
        	if (rs != null)
        	{
        	    rs.close();
        	}	
	    } 
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }
	}
	
    }

    /**
     * Printing table information by giving the names first symbol
     */
    @Override
    public void printPeopleStartSymbol(String symbolinName) 
    {
	try
	{
	    statement = connect.prepareStatement(Query.PRINT_PEOPLE_SYMBOL_QUERY + symbolinName + "%'");
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    while (rs.next()) 
	    {
		String name = rs.getObject(1).toString();
		String age = rs.getObject(2).toString();
		String email = rs.getObject(3).toString();
		String id = rs.getObject(4).toString();
		MainGUI.textArea.append("\nName   : " + name);
		MainGUI.textArea.append("\nAge    : " + age );
		MainGUI.textArea.append("\nEmail  : " + email );
		MainGUI.textArea.append("\nID     : " + id );
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	} 
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
           
    	    try 
    	    {
    		if (rs != null)
        	{
        	    rs.close();
        	}
	    } 
    	    catch (SQLException e)
    	    {
		e.printStackTrace();
	    }
    	
	}
	
    }

    /**
     * Printing people information by giving a city where they travel to
     */
    @Override
    public void printInfoByCity(String city) 
    {
	try
	{
	    statement = connect.prepareStatement(Query.PRINT_INFO_BY_CITY_QUERY + city + "'");
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
    	    
	    while (rs.next()) 
	    {
		String name = rs.getObject(1).toString();
		String age = rs.getObject(2).toString();
		String email = rs.getObject(3).toString();
		String id = rs.getObject(4).toString();
		String ticket = rs.getObject(5).toString();
		String dateofA = rs.getObject(6).toString();
		String dateofD = rs.getObject(7).toString();

		MainGUI.textArea.append("\nName   : " + name);
		MainGUI.textArea.append("\nAge    : " + age );
		MainGUI.textArea.append("\nEmail  : " + email );
		MainGUI.textArea.append("\nID     : " + id );
		MainGUI.textArea.append("\nTicket Number     : " + ticket );
		MainGUI.textArea.append("\nDate of Arival    : " + dateofA);
		MainGUI.textArea.append("\nDate of Departure : " + dateofD );
		MainGUI.textArea.append("\nCity              : " + city);
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	} 
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
            
            try 
            {
        	if (rs != null)
        	{
        	    rs.close();
        	}
	    }
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }
	}
	
    }

    /**
     * Prints the cities ordering them by visitors
     */
    @Override
    public void printOrderedCity()
    {
	try 
	{
	    statement = connect.prepareStatement(Query.PRINT_ORDERED_CITIES_QUERY);
	    
	    rs = statement.executeQuery();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append("List of People: ");
    	    MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    
	    while (rs.next()) 
	    {
		String city = rs.getObject(1).toString();
		String countCities = rs.getObject(2).toString();
		
		MainGUI.textArea.append("\nCity                               : " + city);
		MainGUI.textArea.append("\nNumber of people been in this city : " + countCities );
		MainGUI.textArea.append("\n-----------------------------------------------------------------");
	    }
	    
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
            try 
            {
        	if (rs != null)
        	{
        	    rs.close();
        	}
	    } 
            catch (SQLException e) 
            {
		e.printStackTrace();
	    }
	}
    }

    /**
     * Deletes table contents by giving a table name 
     */
    @Override
    public void deleteTableContent(GetTableInfoDTO dto) 
    {
	try 
	{
	    statement = connect.prepareStatement(Query.DELETE_TABLE_CONTENTS_QUERY + dto.getTable());
	    
	    statement.execute();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append(dto.getTable() + " Table Contents Deleted.");
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
	}
    }

    /**
     * Deleting the whole table by giving a table name 
     */
    @Override
    public void deleteTable(GetTableInfoDTO dto) 
    {
	try
	{
	    statement = connect.prepareStatement(Query.DELETE_TABLE_QUERY + dto.getTable());
	    
	    statement.execute();
	    
	    MainGUI.textArea.setText("");
    	    MainGUI.textArea.append(dto.getTable() + " Table Contents Deleted.");
	} 
	catch (SQLException e) 
	{
	    e.printStackTrace();
	}
	finally
	{
	    closeConnection();
            closeStatement();
	}
    }
   
    
}
