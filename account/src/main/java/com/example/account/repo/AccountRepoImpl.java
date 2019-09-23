package com.example.account.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.account.entity.AccountEntity;
import com.example.account.model.Account;

@Repository
public class AccountRepoImpl implements AccountRepo {
	
	@PersistenceContext
	EntityManager entity;

	@Override
	public Account getDetails(Integer personId) throws Exception {
		// TODO Auto-generated method stub
		
		AccountEntity ae=entity.find(AccountEntity.class, personId);
		
		Account a = new Account();
		a.setPersonId(personId);
		a.setDepartment(ae.getDepartment());
		a.setDesg(ae.getDesg());
		a.setSalary(ae.getSalary());
		return a;
	}
	

}
