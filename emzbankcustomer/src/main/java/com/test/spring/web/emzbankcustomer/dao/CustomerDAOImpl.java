package com.test.spring.web.emzbankcustomer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.spring.web.emzbankcustomer.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session = this.sessionFactory.openSession();
		Customer customer=(Customer)session.get(Customer.class, id);
		session.close();
		return customer;
	}

	@Override
	public void putCustomer(Customer customer) {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(customer);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		Session session = this.sessionFactory.openSession();
		
		return (List<Customer>)session.createQuery("from Customer").list();
	}

}
