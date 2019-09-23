package com.example.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.model.Account;
import com.example.account.service.AccountService;

@RestController
@CrossOrigin
public class AccountController {

	@Autowired
	AccountService as;

	// Fetches call details of a specific customer
	@RequestMapping(value = "/account/{personId}", method = RequestMethod.GET)
	public Account getDetails(@PathVariable Integer personId) {

		Account a= new Account();

		try {
			 a=as.getDetails(personId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
