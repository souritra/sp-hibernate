package com.souritra.javatpoint.pojo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;;;

public class StoreData {

	public static void main(String[] args) {

		// Create typesafe ServiceRegistry object
		StandardServiceRegistry standardServiceRegistry = 
				new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xmlbased.xml")
				.build();

		Metadata metadata = 
				new MetadataSources(standardServiceRegistry)
				.getMetadataBuilder()
				.build();

		SessionFactory factory = 
				metadata
				.getSessionFactoryBuilder()
				.build();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		long time = (new Date()).getTime();
		e1.setId(time);
		e1.setFirstName("Gaurav");
		e1.setLastName("Chawla");

		session.save(e1);
		t.commit();
		System.out.println("successfully saved");
		session.close();
		factory.close();
		

	}
}