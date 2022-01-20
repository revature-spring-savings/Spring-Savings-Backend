package com.projectthree.springbanking.accounts;


import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;
    
    @Autowired
    private UsersRepository usersRepository;

    // deposit money into account
    // should take into account what type of account it is
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
    
    public AccountsEntity createAccount(AccountsEntity accountsEntity, Integer userID) {
    	// retrieve existing user from database
    	UsersEntity usersEntity = usersRepository.findById(userID).get();
    	// create new account
    	AccountsEntity accountEntity = new AccountsEntity();
		accountEntity.setAccountBalance(accountsEntity.getAccountBalance());
		accountEntity.setAccountType(accountsEntity.getAccountType());
		usersEntity.setAccountsEntity(accountEntity);
		
		
//		if(account_type.equalsIgnoreCase("checking")) {
//			System.out.println("works");
////			accountEntity = new Checking(initialDeposit);
//		} 
//		else if(account_type.equalsIgnoreCase("savings")){
//			System.out.println("works");
////			accountEntity = new Savings(initialDeposit);
//
//		}  
		
		// set values for the new account
    	
    	// then add the new account to user
    	
    	// then save/ insert
    	
    }
}
