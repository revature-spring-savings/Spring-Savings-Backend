package com.projectthree.springbanking.accounts;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {
	
	private AccountsRepository accountsRepository;

	@Autowired
	public AccountsService(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}
	
	public List<AccountsEntity> allAccounts() {
		return accountsRepository.findAll();
		
	}
	
	public List<AccountsEntity> allAccountsByID(Integer userID) {
		return accountsRepository.findAllByID(userID);
		
	}
	
	public Optional <AccountsEntity> accountByID(Integer accountID) {
		return accountsRepository.findById(accountID);
		
	}
	
	

}
