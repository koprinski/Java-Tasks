package com.omisoft.basic_java.objects.task3;
import java.lang.reflect.Method;

/**
 * Tests the program
 * 
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Store:");
		Store store = new Store("be3423",30);

		System.out.println("Total staff: " + store.getCount());
		
		Staff staff = new Staff("1256sde",20);
		staff.setFirstName("Ivan");
		staff.setLastName("Ivanov");
		staff.setPaycheck(350);
		
		System.out.println("Staff member: " + staff.getFirstName() + " " + staff.getLastName() + " works for " + staff.getPaycheck() + " $");
		
		
		PersonalCustomers personalcust = new PersonalCustomers("be3423",30);
		personalcust.setFirstName("Borislav");
		personalcust.setLastName("Koprinski");
		personalcust.setGiftCard("Technopolis");
		personalcust.setUserName("bkoprinski");
		
		System.out.println(personalcust.getFirstName()+" "+ personalcust.getLastName()+" with "+ personalcust.getGiftCard()+" gift card and username: "+personalcust.getUserName());
		
		personalcust.giftExp();
		
		Method[] methods = PersonalCustomers.class.getMethods();
		
		for(Method method : methods){
		    //System.out.println("method = " + method.getName());
		    System.out.println(method.getDeclaringClass());
		    //System.out.println(method.getParameterTypes());
		}
		
	}
	

}
