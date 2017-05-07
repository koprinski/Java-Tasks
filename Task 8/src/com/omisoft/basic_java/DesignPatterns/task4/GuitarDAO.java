package com.omisoft.basic_java.DesignPatterns.task4;

import java.util.Hashtable;

/**
 * Creating DAO interface
 * @author bkoprinski
 *
 */
public interface GuitarDAO {
    public Hashtable<Integer, Guitar> getAllGuitars();
    public Guitar getGuitar(int serialNumber);
    public void updateGuitar(Guitar guitar);
    public void deleteGuitar(Guitar guitar);
}
