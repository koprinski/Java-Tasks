package com.omisoft.basic_java.DesignPatterns.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * Creating Cache
 * @author bkoprinski
 *
 */
public class Cache {
    private List<Service> services;

    /**
     * Constructor
     */
    public Cache()
    {
       services = new ArrayList<Service>();
    }

    /**
     * Service getter from the Arraylist
     * @param dtoName
     * @return
     */
    public Service getService(EmployeesDTO dtoName)
    {
	for (Service service : services)
	{
	    if(services.contains(service))
	    {
		System.out.println("Returning cached  "+dtoName.getName()+" which is stored in EmployeesDTO");
		return service;
	    }
     	 }
  	 return null;
    }

    /**
     * Method for adding a new Service if the service isn't in the Arraylist
     * @param newService
     */
    public void addService(Service newService)
    {
  	 boolean exists = false;
  	 for (Service service : services) 
  	 {
  	     if(service.equals(newService.getName()))
  	     {
  		 exists = true;
  	     }
  	 }
  	 if(!exists)
  	 {
  	     services.add(newService);
  	 }
    }
}
