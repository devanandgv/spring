package com.dev.hibernate.mapping.onetoone.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.hibernate.mapping.onetoone.model.Customer;
import com.dev.hibernate.mapping.onetoone.model.CustomerDetails;

public class Main {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.sessionFactory;

		Customer customer = new Customer();

		customer.setFirstName("Dev");
		customer.setLastName("Anand");

		CustomerDetails customerDetails = new CustomerDetails();

		customerDetails.setAge(28);

		customerDetails.setFatherName("Ganesan");
		customerDetails.setGender("MALE");

		customerDetails.setMotherName("Vembu");

		customerDetails.setCustomer(customer);
		customer.setCustomerDetails(customerDetails);

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(customer);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();

	}

}
