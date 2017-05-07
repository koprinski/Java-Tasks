package com.omisoft.basic_java.DesignPatterns.task5;

/**
 * Creating transfer object
 * @author bkoprinski
 *
 */
public class EmployeesDTO {
    private String name;
    private int employeeNum;
    private long id;
    private String position;
    
    /**
     * Constructor
     * @param name
     * @param employeeNum
     * @param position
     * @param id
     */
    EmployeesDTO(String name, int employeeNum, String position, long id)
    {
	this.setName(name);
	this.setEmployeeNum(employeeNum);
	this.id=id;
	this.setPosition(position);
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the id
     */
    public long getId() {
	return id;
    }

    /**
     * @param id2 the id to set
     */
    public void setId(long id2) {
	this.id = id2;
    }

    /**
     * @return the position
     */
    public String getPosition() {
	return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
	this.position = position;
    }

    /**
     * @return the employeeNum
     */
    public int getEmployeeNum() {
	return employeeNum;
    }

    /**
     * @param employeeNum the employeeNum to set
     */
    public void setEmployeeNum(int employeeNum) {
	this.employeeNum = employeeNum;
    }
}
