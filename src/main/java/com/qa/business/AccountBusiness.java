package com.qa.business;

import com.qa.persistence.repository.AccountRepository;

public class AccountBusiness implements  BusinessInterface{

	AccountRepository myRepo;
	
	@Override
	public String getAllAccounts() {
		return myRepo.getAllAccounts();	
	}

	@Override
	public String createAccount(String account) {
		
		return myRepo.createAccount(account);
	}

	@Override
	public String deleteAccount(Long id) {
		return myRepo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		
		return myRepo.updateAccount(id, account);
	}

}
