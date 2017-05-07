package com.omisoft.jsp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.omisoft.jsp.DTO.GetTableInfoDTO;
import com.omisoft.jsp.DTO.Query;

/**
 * Creating a class for working with the SQL database
 * @author bkoprinski
 *
 */
public class AddToTableDAO extends BaseDAO implements TableDAO  {
	private ResultSet rs;
	private ArrayList<String> list;
	
	/**
	 * Constructor
	 */
	public AddToTableDAO()
    {
		try 
		{
		    this.connection();
		} 
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		list = new ArrayList<String>();
    }
	
	/**
	 * Adding user information into database
	 */
	@Override
	public void addToTable(GetTableInfoDTO dto) {
		try 
        {	
     
			statement = connect.prepareStatement(Query.ADD_TO_TABLE_QUERY + 
					"VALUES(?,?,?,?,?)");
			
			statement.setString(1,dto.getFirstName());
			statement.setString(2,dto.getLastName());
			statement.setString(3,dto.getEmail());
			statement.setString(4,dto.getPassword());
			statement.setInt(5,dto.getAge());
			
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
	 * Checking if the username and password are in the database
	 */
	@Override
	public boolean checkUser(String email2, String pass2) {
		String email = null;
		String pass = null;

		try 
		{
			statement = connect.prepareStatement(Query.CHECK_USER);
			 
			rs = statement.executeQuery();
			 
			while (rs.next()) 
			{
				email = rs.getObject(1).toString();
				pass = rs.getObject(2).toString();
				
				list.add(email);
				list.add(pass);
				
			}
			
		}
		catch (SQLException l) 
		{
		    l.printStackTrace();
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
	        catch (SQLException u) 
	        {
	        	u.printStackTrace();
		    }
		}
		
		if(list.contains(email2) && list.contains(pass2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Checking if the email already exists in the database
	 */
	@Override
	public boolean checkEmail(String email2) {
		String email = null;
		
		try 
		{
			statement = connect.prepareStatement(Query.CHECK_USER);
			 
			rs = statement.executeQuery();
			 
			while (rs.next()) 
			{
				email = rs.getObject(1).toString();
				
				list.add(email);
				
			}
			
		}
		catch (SQLException l) 
		{
		    l.printStackTrace();
		}
		
		
		if(list.contains(email2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
