package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Readers;
import Entity.Reports;
import Entity.Staff;
import Entity.Books;
import Entity.Publisher;

public class HibernateUtil {
	private final static SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory()
	{

		try {
			return new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Readers.class).addAnnotatedClass(Books.class).addAnnotatedClass(Publisher.class).addAnnotatedClass(Staff.class).addAnnotatedClass(Reports.class).buildSessionFactory();
			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession()
	{
	  return getSessionFactory().openSession(); //session opened
	}

	

}
