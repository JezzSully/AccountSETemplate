package com.qa.MapTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		assertEquals("Success", myRepo.createAccount(accountJson));
		List<Account> accounts = jsonUtil.getObjectForJSON(myRepo.getAllAccounts(), ArrayList.class);
		assertEquals(1, accounts.size());
	}
	
	@Test
	public void add2AccountTest() {
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		Account myAccount2 = new Account((long) 2, "Test", "Name");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		String accountJson2 = jsonUtil.getJSONForObject(myAccount2);
		assertEquals("Success", myRepo.createAccount(accountJson));
		assertEquals("Success", myRepo.createAccount(accountJson2));
		Account[] accounts = jsonUtil.getObjectForJSON(myRepo.getAllAccounts(), Account[].class);
		assertEquals(2, accounts.length);
	}

	@Test
	public void removeAccountTest() {
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		myRepo.createAccount(accountJson);
		assertEquals("Success", myRepo.deleteAccount((long) 1));
		Account[] accounts = jsonUtil.getObjectForJSON(myRepo.getAllAccounts(), Account[].class);
		assertEquals(0, accounts.length);
	}
	
	@Test
	public void remove2AccountTest() {
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		Account myAccount2 = new Account((long) 2, "Test", "Name");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		String accountJson2 = jsonUtil.getJSONForObject(myAccount2);
		myRepo.createAccount(accountJson);
		myRepo.createAccount(accountJson2);
		assertEquals("Success", myRepo.deleteAccount((long) 1));
		assertEquals("Success", myRepo.deleteAccount((long) 2));
		Account[] accounts = jsonUtil.getObjectForJSON(myRepo.getAllAccounts(), Account[].class);
		assertEquals(0, accounts.length);
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		myRepo.createAccount(accountJson);
		assertEquals("Success", myRepo.deleteAccount((long) 1));
		assertEquals("Id Not Found", myRepo.deleteAccount((long) 2));
	}
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
		//?
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
		//?
	}

	@Test
	public void accountConversionToJSONTest() {
		//?
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
		//?
	}

}
