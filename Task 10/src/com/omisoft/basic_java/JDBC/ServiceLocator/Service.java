package com.omisoft.basic_java.JDBC.ServiceLocator;

/**
 * Create Service interface.
 * @author bkoprinski
 *
 */
public interface Service {
    public int validateAge() throws AgeServiceException;
}
