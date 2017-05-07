package com.omisoft.basic_java.JDBC.DTO;

/**
 * Query with the sql operations kept in strings
 * @author bkoprinski
 *
 */
public class Query {
    public static final String ADD_TO_TABLE_QUERY = "INSERT INTO Task2.People(Name,Age,Email,ID,KeyPeople)";
    public static final String UPDATE_TABLE_QUERY = "update Task2.People set Name=? , Age=? , Email=? , ID=?, KeyPeople=? " + "where ID = ?";
    public static final String PRINT_TABLE_QUERY = "select * from Task2.People";
    public static final String PRINT_PEOPLE_SYMBOL_QUERY = "select * from Task2.People WHERE Name LIKE '";
    public static final String PRINT_INFO_BY_CITY_QUERY = "SELECT Task2.People.Name, Task2.People.Age, Task2.People.Email, Task2.People.ID, Task2.Trip.TicketNumber, Task2.Trip.DateOfArival, Task2.Trip.DateOfDeparture, Task2.Trip.City "
    	+ "FROM People	"
    	+ "JOIN People_Trip ON People.KeyPeople = People_Trip.KeyPeople	"
    	+ "JOIN Trip ON Trip.KeyTrip = People_Trip.KeyTrip "
	+ "Where City = '";
    public static final String PRINT_ORDERED_CITIES_QUERY = "SELECT Task2.Trip.City, count(Task2.Trip.City) AS \"Number of people been in this city\" "
    	+ "FROM Task2.People "
    	+ "JOIN Task2.People_Trip ON Task2.People.KeyPeople = Task2.People_Trip.KeyPeople "
    	+ "JOIN Task2.Trip ON Task2.Trip.KeyTrip = Task2.People_Trip.KeyTrip "
    	+ "GROUP BY City "
    	+ "ORDER BY \"Number of people been in this city\";";
    public static final String DELETE_TABLE_CONTENTS_QUERY = "DELETE FROM ";
    public static final String DELETE_TABLE_QUERY = "DROP TABLE ";

}