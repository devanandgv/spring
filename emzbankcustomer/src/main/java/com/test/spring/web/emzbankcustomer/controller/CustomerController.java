package com.test.spring.web.emzbankcustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.spring.web.emzbankcustomer.model.Customer;
import com.test.spring.web.emzbankcustomer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = { "application/json" })
	public String getCustomer(@PathVariable(name = "customerId") int id) throws JsonProcessingException {

		Customer customer = this.customerService.getCutomer(id);

		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.writeValueAsString(customer);
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
