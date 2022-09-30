package com.souritra.configuration.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class NativeHibernateConfigurer {
    
    private static SessionFactory sessionFactory;
    
    private NativeHibernateConfigurer() {}
    
    public static SessionFactory getSessionFactory() {
	if(sessionFactory == null) {
	    sessionFactory = createSessionFactory();
	}
	return sessionFactory;
    }
    
    private static SessionFactory createSessionFactory() {

	/*
	 * Session 
	 * - SessionFactory 
	 * -- SessionFactoryBuilder 
	 * --- Metadata 
	 * ---- MetadataBuilder
	 * ----- MetadataSources 
	 * ------ ServiceRegistry -> [StandardServiceRegistry, BootstrapServiceRegistry] 
	 * ------- StandardServiceRegistryBuilder , BootstrapServiceRegistryBuilder
	 * 
	 * This code is for understanding purpose, we should use method chain version
	 */

	StandardServiceRegistryBuilder standardServiceRegistryBuilder = getStandardServiceRegistryBuilderWithSettings();
	ServiceRegistry StandardServiceRegistry = standardServiceRegistryBuilder.build();
	MetadataSources metadataSources = getMetadataSources(StandardServiceRegistry);

	// Short hand code
	// MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
	// Metadata metadata = metadataBuilder.build();
	Metadata metadata = metadataSources.buildMetadata();

	// Short hand code
	// SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
	// SessionFactory sessionFactory = sessionFactoryBuilder.build();
	SessionFactory sessionFactory = metadata.buildSessionFactory();
	
	return sessionFactory;

    }

    /*
     * 1) use configure() to load settings from .cfg.xml file default is hibernate.cfg.xml
     * 	- hibernate.cfg.xml file can contain .hbm.xml file as well as configuration settings
     * 
     * 2) use loadProperties() load settings from .properties file
     *  - hibernate.properties file can only contain configuration settings as key value pair
     *  
     * 3) use applySetting() to use hard code values for settings. 
     */
    private static StandardServiceRegistryBuilder getStandardServiceRegistryBuilderWithSettings() {
	StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

	standardServiceRegistryBuilder
		// .configure()
		// .loadProperties("hibernate.properties")
		.applySetting("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
		.applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/test")
		.applySetting("hibernate.connection.username", "root")
		.applySetting("hibernate.connection.password", "S0ur1tr@D@5")
		.applySetting("hibernate.format_sql", "true").applySetting("hibernate.use_sql_comments", "true")
		.applySetting("hibernate.hbm2ddl.auto", "update")
		.applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");

	return standardServiceRegistryBuilder;
    }

    /*
     * 1) use addAnnotatedClass(annotatedClass) to add persistent classes
     * 2) addPackage(packageName) - add all files from packageName
     * 3) addFile(path) - mapping files
     */
    private static MetadataSources getMetadataSources(ServiceRegistry serviceRegistry) {
	MetadataSources metadataSources = new MetadataSources(serviceRegistry);

	metadataSources.addAnnotatedClass(com.souritra.jpwh.domain.helloworld.Message.class);

	return metadataSources;
    }
    
    
}
