package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	AccountMapRepository myRepo;
	JSONUtil jsonUtil;
	
	@Before
	public void setUp() {
		myRepo = new AccountMapRepository();
		jsonUtil = new JSONUtil();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void addAccountTest() {
		Account myAccount = new Account(1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		assertEquals("Success", myRepo.createAccount(accountJson));
	}
	
	@Test
	public void add2AccountTest() {
		//?
	}

	@Test
	public void removeAccountTest() {
		//needs an account in repo
		Account myAccount = new Account(1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		myRepo.createAccount(accountJson);
		assertEquals("Success", myRepo.deleteAccount((long) 1));
	}
	
	@Test
	public void remove2AccountTest() {
		//needs an account in repo
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		assertEquals("Id Not Found", myRepo.deleteAccount((long) 5));
	}
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
	
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
	
	}

	@Test
	public void accountConversionToJSONTest() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		//?
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		//?
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
	}

}
