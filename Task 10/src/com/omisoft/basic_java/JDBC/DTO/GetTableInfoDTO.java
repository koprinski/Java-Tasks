package com.omisoft.basic_java.JDBC.DTO;

/**
 * Getters and setters of the people information in the sql table
 * @author bkoprinski
 *
 */
public class GetTableInfoDTO {
    private String Name;
    private int Age;
    private String Email;
    private String ID;
    private int KeyPeople;
    private String table;
    
    /**
     * Constructor
     * @param Name
     * @param Age
     * @param Email
     * @param ID
     * @param KeyPeople
     */
    public GetTableInfoDTO(String Name, int Age, String Email, String ID, int KeyPeople)
    {
	this.Name=Name;
	this.Age=Age;
	this.Email=Email;
	this.ID=ID;
	this.KeyPeople=KeyPeople;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * @return the age
     */
    public int getAge() {
        return Age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        Age = age;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return Email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        Email = email;
    }
    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }
    /**
     * @param iD the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }
    /**
     * @return the keyPeople
     */
    public int getKeyPeople() {
        return KeyPeople;
    }
    /**
     * @param keyPeople the keyPeople to set
     */
    public void setKeyPeople(int keyPeople) {
        KeyPeople = keyPeople;
    }

    /**
     * @return the table
     */
    public String getTable() {
	return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(String table) {
	this.table = table;
    }
    
    
}
