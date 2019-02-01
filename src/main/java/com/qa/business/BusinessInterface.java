package com.qa.business;

public interface BusinessInterface {

	String getAllAccounts();

	String createAccount(String account);

	String deleteAccount(Long id);

	String updateAccount(Long id, String account);
}
