package com.projectthree.springbanking.accounts;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectthree.springbanking.transactions.TransactionsEntity;

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
	
//	public Optional <AccountsEntity> accountByID(Integer accountID) {
//		return accountsRepository.findById(accountID);
		
//	}
	
	 public AccountsEntity deposit(TransactionsEntity transactionEntity, Integer accountID) {
	        // deposit amount
	        double depositAmt =  transactionEntity.getAmount();
	        // retrieve account from database
	        AccountsEntity accountEntity = accountsRepository.findById(accountID).get();
	        // current account balance;
	        double currBal = accountEntity.getAccountBalance();
	        // new account balance;
	        double newAcctBal = currBal + depositAmt;
	        // set new balance;
	        accountEntity.setAccountBalance(newAcctBal);
	        //save new balance into db
	        accountsRepository.save(accountEntity);
	        return accountEntity;
	    }

	    // withdraw money from account

	    public AccountsEntity withdraw(TransactionsEntity transactionEntity, Integer accountID) {
	        // withdraw amt
	        double withdrawAmt = transactionEntity.getAmount();
	        // retrieve account from db
	        AccountsEntity accountEntity = accountsRepository.findById(accountID).get();
	        // current account balance;
	        double currBal = accountEntity.getAccountBalance();
	        // new account balance;
	        double newAcctBal = currBal - withdrawAmt;
	        // set new balance;
	        accountEntity.setAccountBalance(newAcctBal);
	        accountsRepository.save(accountEntity);
	        return accountEntity;
	    }
	
	

}
