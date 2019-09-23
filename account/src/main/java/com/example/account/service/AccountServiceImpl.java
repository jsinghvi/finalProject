package com.example.account.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.account.model.Account;
import com.example.account.repo.AccountRepo;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepo ar;

	@Override
	public Account getDetails(Integer personId) throws Exception {
		// TODO Auto-generated method stub
		
		Account a = ar.getDetails(personId);
		return a;
	}

}
