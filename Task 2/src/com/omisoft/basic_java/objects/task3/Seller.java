package com.omisoft.basic_java.objects.task3;


/**
 * Creates class Seller which extends Staff
 * @author bkoprinski
 *
 */
public class Seller extends Staff {
	private int id;
	private int age;
	
	public Seller(String identNumber,int count) {
		super(identNumber, count);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
