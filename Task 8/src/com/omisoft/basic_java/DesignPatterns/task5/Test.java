package com.omisoft.basic_java.DesignPatterns.task5;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

    public static void main(String[] args) {
	EmployeesBO obj = new EmployeesBO();
	
	//Prints all the employees
	for (EmployeesDTO empl : obj.getAllEmpl()) {
	    System.out.println("Name : "+empl.getName());
	    System.out.println("Id: " + empl.getId());
	    System.out.println("Employee number : " + empl.getEmployeeNum());
	    System.out.println("Position : "+empl.getPosition());
	    System.out.println("-------------------------------------------------");
	}
	
	//Updates the employee which is saved at index 0 in the ArrayList
	EmployeesDTO empl = obj.getAllEmpl().get(0);
	empl.setPosition("Boss");
	obj.updateEmpl(empl);
	
	//Gets the employee saved at index 0 in the ArrayList
	obj.getEmpl(0);
	System.out.println("-------------------------------------------------");
	System.out.println("Name : "+empl.getName());
	System.out.println("Id: " + empl.getId());
	System.out.println("Employee number : " + empl.getEmployeeNum());
	System.out.println("Position : "+empl.getPosition());
	
    }

}
