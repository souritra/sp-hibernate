package com.souritra.jpwh.service.helloworld;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.souritra.configuration.hibernate.NativeHibernateConfigurer;
import com.souritra.jpwh.domain.helloworld.Message;

public class HelloWorldHibernateService {

    public static void main(String args[]) throws Exception {
	HelloWorldHibernateService helloWorldService = new HelloWorldHibernateService();
	helloWorldService.storeMessage();
	helloWorldService.loadMessage();
    }

    public void storeMessage() throws Exception {
	SessionFactory sessionFactory = NativeHibernateConfigurer.getSessionFactory();
	Session session = null;
	Transaction tx = null;
	try {

	    // Whenever you call getCurrentSession() in the same thread you get
	    // the same org.hibernate.Session.
	    // It's bound automatically to the ongoing transaction and is closed for you
	    // automatically when that transaction commits or rolls back.
	    session = sessionFactory.openSession();

	    // Get access to the standard transaction API UserTransaction and
	    // begin a transaction on this thread of execution.
	    tx = session.beginTransaction();
	    tx.begin();

	    Message message = new Message();
	    message.setText("Hello World!");

	    // native Hibernate API is very similar to the standard Java Persistence API and
	    // most methods have the same name.
	    session.persist(message);

	    // Hibernate synchronizes the session with the database and closes the "current"
	    // session on commit of the bound transaction automatically.
	    // INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World!')
	    tx.commit();
	} catch (Exception e) {
	    // TODO: handle exception
	} finally {
	    if (tx != null) {
		tx.rollback();
	    } 
	    if (session != null) {
		session.close();;
	    }
	    if (sessionFactory != null) {
		sessionFactory.close();;
	    }
	}
    }
    
    public void loadMessage() throws Exception {
	SessionFactory sessionFactory = NativeHibernateConfigurer.getSessionFactory();
	Session session = null;
	Transaction tx = null;
	try {

	    session = sessionFactory.openSession();
		tx = session.beginTransaction();
		tx.begin();

		// A Hibernate criteria query is a type-safe programmatic way to
		// express queries, automatically translated into SQL.
		List<Message> messages = session.createCriteria(Message.class).list(); // SELECT * from MESSAGE

		System.out.println("TEST " + messages.size() + "=" + 1);
		System.out.println("TEST " + messages.get(0).getText() + "=" + "Hello World!");

		tx.commit();
	} catch (Exception e) {
	    // TODO: handle exception
	} finally {
	    if (tx != null) {
		tx.rollback();
	    } 
	    if (session != null) {
		session.close();;
	    }
	    if (sessionFactory != null) {
		sessionFactory.close();;
	    }
	}
    }
}
