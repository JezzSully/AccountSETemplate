package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.AccountBusiness;

@Path("/accounts")
public class AccountEndpoints{
	
	@Inject
	private AccountBusiness service;
	
	@Path("/")
	@GET
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/{id}")
	@GET
	public String findAnAccount(@PathParam("id")long id) {
		return service.findAnAccount(id);
	}
	
	@Path("/")
	@POST
	public String createAnAccount(String account) {
		return service.createAccount(account);
	}
	
	@Path("/{id}")
	@POST
	public String updateAnAccount(@PathParam("id")long id, String account) {
		return service.updateAccount(id, account);
	}
	
	@Path("/{id}")
	@DELETE
	public String deleteAccount(@PathParam("id")long id) {
		return service.deleteAccount(id);
	}
}
