package com.omisoft.basic_java.DesignPatterns.task6;

/**
 * Creating initial context for lookup
 * @author bkoprinski
 *
 */
public class InitialContext {
    /**
     * Method for searching
     * @param dtoName
     * @return
     */
    public Object lookup(EmployeesDTO dtoName)
    {
	if(dtoName.getName().equalsIgnoreCase("Petur Vasilev"))
	{
	    System.out.println("Looking up and creating a new Service1 object");
	    return new Service1();
	}
	return null;
	
    }
}
