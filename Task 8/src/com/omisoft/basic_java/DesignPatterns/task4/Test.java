package com.omisoft.basic_java.DesignPatterns.task4;

/**
 * Tests the program
 * @author bkoprinski
 *
 */
public class Test {

    public static void main(String[] args) {
	GuitarDAO guitarDao = new GuitarDaoImplement();
	Guitar guitar ;
	

	guitar = guitarDao.getAllGuitars().get(111000999);
	guitar.setPostModel("Jimi Hendrix leftie");
	guitar.setPrice(4500);
	guitar.setSerialNumber(10001);
	guitarDao.updateGuitar(guitar);
	
	guitarDao.getGuitar(10001);
	System.out.println("Guitar: "+guitar.getModel()+" "+guitar.getPostModel());
	System.out.println("serial number: "+guitar.getSerialNumber());
	System.out.println("price: "+guitar.getPrice());

    }

}
