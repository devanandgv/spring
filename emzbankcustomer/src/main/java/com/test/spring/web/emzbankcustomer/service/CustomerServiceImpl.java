package com.test.spring.web.emzbankcustomer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.web.emzbankcustomer.dao.CustomerDAO;
import com.test.spring.web.emzbankcustomer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public Customer getCutomer(int id) {

		Customer customer = this.customerDAO.getCustomer(id);

		logger.info("getCustomer ended");
		return customer;
	}

	@Override
	public String putCustomer(Customer customer) {

		this.customerDAO.putCustomer(customer);
		
		return "";
	}
	@Override
	public List<Customer> getAllCustomer() {
	
		return this.customerDAO.getAllCustomer();
	}
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}


}
