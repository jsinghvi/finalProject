package com.example.account.repo;

import com.example.account.model.Account;

public interface AccountRepo {

	public Account getDetails(Integer personId) throws Exception;
}
