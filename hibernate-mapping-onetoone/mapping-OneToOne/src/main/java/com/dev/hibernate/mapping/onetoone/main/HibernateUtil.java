package com.dev.hibernate.mapping.onetoone.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		return new Configuration().configure().buildSessionFactory();
	}
	public static void shutdown() {
		sessionFactory.close();
	}

}
