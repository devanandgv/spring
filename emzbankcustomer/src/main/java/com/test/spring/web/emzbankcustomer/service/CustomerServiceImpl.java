package com.test.spring.web.emzbankcustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.web.emzbankcustomer.dao.CustomerDAO;
import com.test.spring.web.emzbankcustomer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public Customer getCutomer(int id) {

		Customer customer = this.customerDAO.getCustomer(id);

		return customer;
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
