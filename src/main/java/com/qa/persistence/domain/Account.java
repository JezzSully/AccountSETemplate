package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long accountNumber;
	private String firstName;
	private String lastName;
	
	public Account() {
		
	}
	
	public Account(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	public Account(Long id, String first, String last) {
		this.accountNumber = id;
		this.firstName = first;
		this.lastName = last;
	}
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
