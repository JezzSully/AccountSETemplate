package com.qa.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
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
		Account[] accounts = jsonUtil.getObjectForJSON(myRepo.getAllAccounts(), Account[].class);
		assertEquals(1, accounts.length);
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
		Account myAccount = new Account((long)1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		System.out.println(accountJson);
		assertEquals("{\"id\":0,\"accountNumber\":1,\"firstName\":\"Jeremy\",\"lastName\":\"Sullivan\"}", accountJson);
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		assertEquals(0, myRepo.countFirstNames("TestName"));
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		myRepo.createAccount(accountJson);
		assertEquals(1,myRepo.countFirstNames("Jeremy"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		Account myAccount = new Account((long) 1, "Jeremy", "Sullivan");
		String accountJson = jsonUtil.getJSONForObject(myAccount);
		myRepo.createAccount(accountJson);
		Account myAccount2 = new Account((long) 2, "Jeremy", "Surname");
		String accountJson2 = jsonUtil.getJSONForObject(myAccount2);
		myRepo.createAccount(accountJson2);
		Account myAccount3 = new Account((long) 3, "FirstName", "Sullivan");
		String accountJson3 = jsonUtil.getJSONForObject(myAccount3);
		myRepo.createAccount(accountJson3);
		assertEquals(2,myRepo.countFirstNames("Jeremy"));
	}

}
