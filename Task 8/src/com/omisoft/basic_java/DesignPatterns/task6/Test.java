package com.omisoft.basic_java.DesignPatterns.task6;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

    public static void main(String[] args) {
	EmployeesDTO dto = new EmployeesDTO("Petur Vasilev", 1, "Crew member", 921112342);
	
	Service service = ServiceLocator.getService(dto);
	service.execute();

	service = ServiceLocator.getService(dto);
	service.execute();
	
    }

}
