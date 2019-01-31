package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository{

	JSONUtil jsonUtil = new JSONUtil();
	Map<Long, Account> account = new HashMap<>();

	public String getAllAccounts() {		
		return jsonUtil.getJSONForObject(account.values());
	}

	public String createAccount(String account) {
		
		Account newAccount;
		newAccount = jsonUtil.getObjectForJSON(account, Account.class);
		this.account.put(newAccount.getAccountNumber(), newAccount);
		return "Success";
	}

	public String deleteAccount(Long id) {
		
		if(account.containsKey(id)) {
			account.remove(id);
			return "Success";
		} else {
			return "Id Not Found";
		}
	}

	public String updateAccount(Long id, String account) {
		if(this.account.containsKey(id)) {
			Account newAccount;
			newAccount = jsonUtil.getObjectForJSON(account, Account.class);
			this.account.put(id, newAccount);
			return "Success";
		} else {
			return "Id Not Found";
		}

	}
	
	public int countFirstNames(String firstName) {
		
		int count = 0;
		
		for(Long key : this.account.keySet()) {
			if(this.account.get(key).getFirstName().equals(firstName)) {
				count++;
			}
		}
		return count;
	}

}
