package com.omisoft.basic_java.DesignPatterns.task6;

/**
 * Creating Service Locator
 * @author bkoprinski
 *
 */
public class ServiceLocator {
   private static Cache cache;
   
   /**
    * Static block
    */
   static
   {
       cache = new Cache();
   }
   
   /**
    * Service getter
    * @param dtoName
    * @return
    */
   public static Service getService(EmployeesDTO dtoName)
   {
       Service service = cache.getService(dtoName);
       
       if(service != null)
       {
	   return service;
       }
       
       InitialContext context = new InitialContext();
       Service service1 = (Service) context.lookup(dtoName);
       cache.addService(service1);
       return service1;
   }
}
