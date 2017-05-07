package com.omisoft.basic_java.JDBC.ServiceLocator;

import com.omisoft.basic_java.JDBC.GUI.AddUI;

/**
 * Create concrete service for validating the age in the Adding people information form
 * @author bkoprinski
 *
 */
public class ValidateAgeService implements Service{

    /**
     * Method for validating peoples when adding new information in the sql table age
     */
    @Override
    public int validateAge() throws AgeServiceException 
    {
	int age = Integer.parseInt(AddUI.ageText.getText());
	
	if (age<3 || age>120)
	{
	    throw new AgeServiceException("Please write a number between [3,120]. ");
	}
	else
	{
	    return age;
	}
	
    }

}
