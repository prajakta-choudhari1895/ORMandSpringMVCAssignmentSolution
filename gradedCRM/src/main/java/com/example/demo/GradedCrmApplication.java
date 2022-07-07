package com.example.demo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;

@SpringBootApplication
public class GradedCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradedCrmApplication.class, args);
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = con.buildSessionFactory();
		CustomerService customerService = new CustomerServiceImpl(sessionFactory);
		List<Customer> CustomerList = customerService.findAll();
		for (Customer customer : CustomerList) {
			System.out.println(customer.toString());
		}
	}

}
