package com.omisoft.basic_java.DesignPatterns.task6;

/**
 * Creating Service1
 * @author bkoprinski
 *
 */
public class Service1 implements Service {
    EmployeesDTO dto;
   
    /**
     * Method which is printing a message
     */
    public void execute()
    {
	System.out.println("Executing EmployeesDTO");
    }

    /**
     * Getting an object from EmployeesDTO
     */
    @Override
    public EmployeesDTO getName() 
    {
	return dto ;
    }

}
