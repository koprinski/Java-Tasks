package com.omisoft.basic_java.objects.task3;


/**
 * Creates class Customers that extends Store
 * @author bkoprinski
 *
 */
public class Customers extends Store {
	private String firstName;
	private String lastName;
	
	public Customers(String identNumber, int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
