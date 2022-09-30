package com.souritra.configuration.hibernate;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaHibernateConfigurer {
    
    private static EntityManagerFactory entityManagerFactory;
    private static Map<String, String> properties = new HashMap<String, String>();
    private static String persistenceUnitName = "HelloWorldPU";
    
    private JpaHibernateConfigurer() {}
    
    private static EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(persistenceUnitName, properties);
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
	if(entityManagerFactory == null ) {
	    entityManagerFactory = createEntityManagerFactory();
	}
	return entityManagerFactory;
    }
    
    
}
