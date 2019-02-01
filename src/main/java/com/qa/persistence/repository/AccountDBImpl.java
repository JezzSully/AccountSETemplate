package com.qa.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Transactional(SUPPORTS)
@Default
public class AccountDBImpl implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a", Account.class);
		return jsonUtil.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account myAccount = jsonUtil.getObjectForJSON(account, Account.class);
		manager.persist(myAccount);
		return "{\"message\": \"Success\"}";
		// return a string for success in JSON.
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account myAccount = manager.find(Account.class, id);
		if (myAccount != null) {
			manager.remove(myAccount);
			return "{\"message\": \"Success\"}";
		} else {
			return "{\"message\": \"Fail\"}";
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		if (deleteAccount(id).equals("{\"message\": \"Success\"}")) {
			createAccount(account);
			return "{\"message\": \"Success\"}";
		} else {
			return "{\"message\": \"Fail\"}";
		}
	}

}
