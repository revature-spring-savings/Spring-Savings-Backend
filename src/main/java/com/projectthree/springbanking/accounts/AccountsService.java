package com.projectthree.springbanking.accounts;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersRepository;
import com.projectthree.springbanking.accounts.AccountsRepository;

@Service
public class AccountsService {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	    private UsersRepository usersRepository;

	@Autowired
	public AccountsService(AccountsRepository accountsRepository, UsersRepository usersRepository) {
		this.accountsRepository = accountsRepository;
		this.usersRepository = usersRepository;
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
	    
	    public UsersEntity createAccount(AccountsEntity accountsEntity, Integer userID) {
	        // retrieve existing user from database
	        UsersEntity usersEntity = usersRepository.findById(userID).get();
	        System.out.println(usersEntity);
	        // create new account
	        AccountsEntity accountEntity = new AccountsEntity();
	        Set<AccountsEntity> accountSet = new HashSet<AccountsEntity>();
	        accountEntity.setAccountBalance(accountsEntity.getAccountBalance());
	        accountEntity.setAccountType(accountsEntity.getAccountType());
	        accountEntity.setUsersEntity(usersEntity);
	        accountsRepository.save(accountEntity);
	        accountSet.add(accountEntity);


	        System.out.println(accountEntity);
	        usersEntity.setAccountsEntity(accountSet);

	        usersRepository.save(usersEntity);
	        return usersEntity;
	        }
	
	

}
