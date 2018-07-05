package com.test.spring.web.emzbankcustomer.dao;

import java.util.List;

import com.test.spring.web.emzbankcustomer.model.Customer;

public interface CustomerDAO {

	public Customer getCustomer(int id);
	public void putCustomer(Customer customer);
	public List<Customer> getAllCustomer();
}
