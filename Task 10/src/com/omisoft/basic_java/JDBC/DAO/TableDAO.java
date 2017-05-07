package com.omisoft.basic_java.JDBC.DAO;

import com.omisoft.basic_java.JDBC.DTO.GetTableInfoDTO;

/**
 * Table interface
 * @author bkoprinski
 *
 */
public interface TableDAO {

    /**
     * This interface represents a method for adding people information in the sql table
     * @param dto
     */
    public void addToTable(GetTableInfoDTO dto);
    
    /**
     * This interface represents a method for updating people information in the sql table
     * @param dto
     */
    public void updateTable(GetTableInfoDTO dto);
    
    /**
     * This interface represents a method for printing people information from the sql table
     */
    public void printTable();
    
    /**
     * This interface represents a method for printing people information from the sql table
     * by giving a starting symbol of the persons name
     * @param symbolinName
     */
    public void printPeopleStartSymbol(String symbolinName);
    
    /**
     * This interface represents a method for printing people information from the sql table
     * by giving a city where he takes a trip to
     * @param city
     */
    public void printInfoByCity(String city);
    
    /**
     * This interface represents a method for printing the cities ordering them by visitors
     */
    public void printOrderedCity();
    
    /**
     * This interface represents a method for deleting table contents by giving a table name 
     * @param dto
     */
    public void deleteTableContent(GetTableInfoDTO dto);
    
    /**
     * This interface represents a method for deleting the whole table by giving a table name 
     * @param dto
     */
    public void deleteTable(GetTableInfoDTO dto);
}
