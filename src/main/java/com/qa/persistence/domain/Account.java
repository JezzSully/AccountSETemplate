package com.qa.persistence.domain;

public class Account {
	
	private long accountNumber;
	private String firstName;
	private String lastName;
	
	public Account() {
		
	}
	
	public Account(long id, String first, String last) {
		this.accountNumber = id;
		this.firstName = first;
		this.lastName = last;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
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
