package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;

@Component
public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int id);

	// save or update
	public void save(Customer theCustomer);

	// delete by Id
	public void deleteById(int id);

}
