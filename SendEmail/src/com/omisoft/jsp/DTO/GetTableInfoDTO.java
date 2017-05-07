package com.omisoft.jsp.DTO;

/**
 * Getters and setters of the users information in the sql database
 * @author bkoprinski
 *
 */
public class GetTableInfoDTO {
	
	/**
	 * Constructor
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param age
	 */
	public GetTableInfoDTO(String firstname, String lastname, String email, String password, int age)
	{
		this.FirstName=firstname;
		this.LastName=lastname;
		this.Email=email;
		this.setPassword(password);
		this.Age=age;
	}
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private int Age;
}
