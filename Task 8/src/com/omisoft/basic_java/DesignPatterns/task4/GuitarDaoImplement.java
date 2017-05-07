package com.omisoft.basic_java.DesignPatterns.task4;

import java.util.Hashtable;

/**
 * Creates class which implements the DAO interface
 * @author bkoprinski
 *
 */
public class GuitarDaoImplement implements GuitarDAO {
    private Hashtable<Integer, Guitar> guitars;

    /**
     * Constructor in which we add some objects in a hashtable
     */
    public GuitarDaoImplement()
    {
	guitars = new Hashtable<Integer, Guitar>();
	Guitar guitar1 = new Guitar("Gibson", "les paul", 2300);
	Guitar guitar2 = new Guitar("Gibson", "SG", 2500);
	Guitar guitar3 = new Guitar("Gibson", "EST", 3300);
	Guitar guitar4 = new Guitar("Fender", "Stratocaster", 1300);
	Guitar guitar5 = new Guitar("Fender", "Telecaster", 1600);
	guitars.put(111333222, guitar1);
	guitars.put(111322111, guitar2);
	guitars.put(222111000, guitar3);
	guitars.put(000555666, guitar4);
	guitars.put(111000999, guitar5);
    }
    
    /**
     * Method which returns the hashtable
     */
    @Override
    public Hashtable<Integer, Guitar> getAllGuitars() 
    {
	return guitars;
    }

    /**
     * Updating the hashtable by using the serial number
     */
    @Override
    public void updateGuitar(Guitar guitar) 
    {
	guitars.get(guitar.getSerialNumber());
	System.out.println("Guitar with serial number : " + guitar.getSerialNumber() + " is updated !");
    }

    /**
     * Deleting object from the hashtable using the serial number
     */
    @Override
    public void deleteGuitar(Guitar guitar) {
	guitars.remove(guitar.getSerialNumber());
	System.out.println("Guitar with serial number : " + guitar.getSerialNumber() + " is removed !" );
    }

    /**
     * Returns only the object which is with the concrete serial number
     */
    @Override
    public Guitar getGuitar(int serialNumber) 
    {
	return guitars.get(serialNumber);
    }

    
    
}
