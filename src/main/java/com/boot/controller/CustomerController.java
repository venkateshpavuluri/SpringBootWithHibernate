package com.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.model.Customer;
import com.boot.service.CustomerService;
@Controller
public class CustomerController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
 
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllCustomers(Model model) {
		LOGGER.debug("This is a debug message");
	    LOGGER.info("This is an info message");
	    LOGGER.warn("This is a warn message");
	    LOGGER.error("This is an error message");
		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return "customerDetails";
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToHomePage() {
		return "redirect:getAllCustomers";
	}
	
	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
	}
 
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {	
		if(customer.getId()==0)
		{
			customerService.addCustomer(customer);
		}
		else
		{	
			customerService.updateCustomer(customer);
		}
 
		return "redirect:/getAllCustomers";
	}
 
	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id,Model model) {
		model.addAttribute("customer", this.customerService.getCustomer(id));
		model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
		return "customerDetails";
	}
 
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/getAllCustomers";
 
	}	

}
