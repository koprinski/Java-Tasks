package com.omisoft.basic_java.DesignPatterns.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Creating an business object
 * @author bkoprinski
 *
 */
public class EmployeesBO {
    List<EmployeesDTO> empl;
    
    /**
     * Constructor in which we add objects in an ArrayList
     */
    public EmployeesBO()
    {
	empl = new ArrayList<EmployeesDTO>();
	EmployeesDTO employee1 = new EmployeesDTO("Petur Vasilev", 1, "Crew member", 921112342);
	EmployeesDTO employee2 = new EmployeesDTO("Kiril Manev", 2, "Manager", 921112142);
	EmployeesDTO employee3 = new EmployeesDTO("Velik Georgiev", 3, "Casher", 901112653);
	empl.add(employee1);
	empl.add(employee2);
	empl.add(employee3);
    }
    
    /**
     * Method for deleting an object from the ArrayList
     * @param em
     */
    public void deleteEmpl(EmployeesDTO em)
    {
	empl.remove(em.getEmployeeNum());
	System.out.println("Employee with number "+em.getEmployeeNum() + " is removed from the list");
    }
    
    /**
     * Method for printing all the elements in the ArrayList
     * @return - ArrayList
     */
    public List<EmployeesDTO> getAllEmpl()
    {
	return empl;
    }
    
    /**
     * Method for updating the information in the ArrayList
     * @param em
     */
    public void updateEmpl(EmployeesDTO em)
    {
	empl.get(em.getEmployeeNum()).setName(em.getName());
	System.out.println("Employee : "+em.getName()+" with employee number "+em.getEmployeeNum()+" is updated!");
    }
    
    /**
     * Method for getting an object from the ArrayList by using the Employee number
     * @param EmployeeNum
     * @return - the object
     */
    public EmployeesDTO getEmpl(int EmployeeNum)
    {
	return empl.get(EmployeeNum);
    }
    
}
