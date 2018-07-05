package com.test.spring.web.emzbankcustomer.service;

import java.util.List;

import com.test.spring.web.emzbankcustomer.model.Customer;

public interface CustomerService {

	public Customer getCutomer(int id);
	public String putCustomer(Customer customer);
	public List<Customer> getAllCustomer();
}
