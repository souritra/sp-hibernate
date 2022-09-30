package com.souritra.jpwh.service.helloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.souritra.configuration.hibernate.JpaHibernateConfigurer;
import com.souritra.jpwh.domain.helloworld.Message;

public class HelloWorldJpaService {

    public static void main(String args[]) throws Exception {
	HelloWorldJpaService helloWorldService = new HelloWorldJpaService();
	helloWorldService.storeMessage();
	//helloWorldService.loadMessage();
    }

    public void storeMessage() throws Exception {
	EntityManagerFactory entityManagerFactory = JpaHibernateConfigurer.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	try {
	    entityManager.getTransaction().begin();
		Message message = new Message();
		message.setText("Hello World!");
		entityManager.persist(message);
		entityManager.getTransaction().commit();
	} finally {
	    entityManager.close();  
	    entityManagerFactory.close();  
	}
	
    }

    public void loadMessage() throws Exception {
	EntityManagerFactory entityManagerFactory = JpaHibernateConfigurer.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	try {
	    entityManager.getTransaction().begin();
	  //List<Message> messages = entityManager.(Message.class).list(); 
	    entityManager.getTransaction().commit();
	} finally {
	    entityManager.close();  
	    entityManagerFactory.close();  
	}
	
    }
}
