package com.omisoft.jsp.DTO;

/**
 * Query with the sql operations kept in strings
 * @author bkoprinski
 *
 */
public class Query {
	public static final String ADD_TO_TABLE_QUERY = "INSERT INTO SendEmail.SendInfo(FirstName, LastName, Email, Password, Age)";
	public static final String CHECK_USER = "select Email, Password from SendEmail.SendInfo";
}
