package com.omisoft.jsp.DAO;

import com.omisoft.jsp.DTO.GetTableInfoDTO;

public interface TableDAO {
	/**
     * This interface represents a method for adding people information in the sql table
     * @param dto
     */
    public void addToTable(GetTableInfoDTO dto);
	
    /**
	 * Checks user
	 * @param user username to check
	 * @param pass password
	 * @return true if user exists
	 */
    public boolean checkUser(String user, String pass);
    
    /**
     * Checks if email exists
     * @param email email to check
     * @return true if exists
     */
    public boolean checkEmail(String email);
}
