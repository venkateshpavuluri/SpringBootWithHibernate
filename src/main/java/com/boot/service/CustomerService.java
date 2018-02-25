package com.boot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.CustomerDao;
import com.boot.model.Customer;
@Service("customerService")
@Transactional
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
 
	
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
 

	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
 
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
 
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
 
	}
 
	
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

}
