package com.example.demo.service;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;

	private Session session;

	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
	}
	
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
		tx.commit();
		return customers;
	}
	
	@Transactional
	public Customer findById(int id) {
		Customer customer=session.get(Customer.class, id);
		return customer;
	}
	
	@Transactional
	public void save(Customer theCustomer) {
		session.saveOrUpdate(theCustomer);
	}
	
	@Transactional
	public void deleteById(int theId) {
		Customer customer = session.get(Customer.class, theId);
		session.delete(customer);
	}
}
