package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountBusiness implements BusinessInterface {

	@Inject
	private AccountRepository myRepo;

	@Inject
	private JSONUtil jsonUtil;

	@Override
	public String getAllAccounts() {
		return myRepo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		Account myAccount = jsonUtil.getObjectForJSON(account, Account.class);
		if (myAccount.getAccountNumber() == 9) {
			return "{\"message\": \"This account is blocked\"}";
		} else {
			return myRepo.createAccount(account);
		}
	}

	public String findAnAccount(Long id) {
		Account[] accounts = jsonUtil.getObjectForJSON(myRepo.getAllAccounts(), Account[].class);
		for (Account a : accounts) {
			if (a.getId() == id) {
				return jsonUtil.getJSONForObject(a);
			}
		}
		return "{\"message\" : \"Account Not Found\"}";
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
