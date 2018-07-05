package com.test.spring.web.emzbankcustomer.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	ObjectMapper objectMapper = new ObjectMapper();
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<String> getCustomer(@PathVariable(name = "customerId") int id)
			throws JsonProcessingException {

		logger.info("getCustomer Started: customerId - {}", id);
		Optional<Customer> customer = Optional.ofNullable(this.customerService.getCutomer(id));
		ResponseEntity<String> response;
		if (customer.isPresent()) {

			response = new ResponseEntity<String>(objectMapper.writeValueAsString(customer.get()), HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("{\"message\":\"Not Found\"}", HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@PostMapping
	public ResponseEntity<String> putCustomer(@RequestBody Customer customer) {
		
		logger.info("customerId : {} :: customerName : {}", customer.getId(),customer.getName());
		this.customerService.putCustomer(customer);
		return new ResponseEntity<String>("{\"message\":\"Success\"}", HttpStatus.OK);
	}

	public CustomerService getCustomerService() {
		return customerService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		return new ResponseEntity<List<Customer>>(this.customerService.getAllCustomer(),HttpStatus.OK);
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
}
