package com.boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1922864783279750149L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
 
	@Column(name="customerName")
	private String customerName; 
 
	@Column(name="email")
	private String email;
 
	public Customer() {
		super();
	}
	public Customer(String customerName,String email) {
		super();
		this.customerName=customerName;
		this.email=email;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
