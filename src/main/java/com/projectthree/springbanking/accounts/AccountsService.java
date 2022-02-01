package com.projectthree.springbanking.accounts;


import com.projectthree.springbanking.accounts.AccountsEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersRepository;


import java.util.Set;

import com.projectthree.springbanking.transactions.TransactionsRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectthree.springbanking.exception.SpringBankingAPIException;




@Service
public class AccountsService {
	
	
    @Autowired
    private AccountsRepository accountsRepository;
    
	@Autowired
	    private UsersRepository usersRepository;
	
	@Autowired
    private TransactionsRepository transactionsRepository;

	@Autowired
	public AccountsService(AccountsRepository accountsRepository, UsersRepository usersRepository) {
		this.accountsRepository = accountsRepository;
		this.usersRepository = usersRepository;
	}
	
	public List<AccountsEntity> allAccounts() {
		return accountsRepository.findAll();
		
	}
	
	public List<AccountsEntity> allAccountsByID(Integer userID) {
		return accountsRepository.findByuserID(userID);
		
	}

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

	public Optional <AccountsEntity> accountByID(Integer accountID) {
		return accountsRepository.findById(accountID);
		
	}
	public static Scanner keyboard = new Scanner(System.in);


    //andy method

    // deposit money into account
    // should take into account what type of account it is
    public AccountsEntity deposit(TransactionsEntity transactionEntity, Integer accountID) {
        // deposit amount
        double depositAmt =  transactionEntity.getAmount();
        Set<TransactionsEntity> transactionSet = new HashSet<TransactionsEntity>();
        // retrieve account from database
        AccountsEntity accountEntity = accountsRepository.findById(accountID).get();
        // retrieve user id using account entity
        UsersEntity usersEntity = usersRepository.findById(accountEntity.getUserID()).get();
        // System.out.println(usersEntity);
        // new transaction
        TransactionsEntity newTransaction = new TransactionsEntity();
        newTransaction.setTransactionDate(transactionEntity.getTransactionDate());
        newTransaction.setTransactionNote(transactionEntity.getTransactionNote());
        newTransaction.setTransactionType(transactionEntity.getTransactionType());
        newTransaction.setAmount(transactionEntity.getAmount());
        // saves account entity to transaction
        newTransaction.setAccountsEntity(accountEntity);
        // saves user entity to transaction
        newTransaction.setUsersEntity(usersEntity);
        // save new transaction to transaction table
        transactionsRepository.save(newTransaction);
        transactionSet.add(newTransaction);
        // current account balance;
        double currBal = accountEntity.getAccountBalance();
        // new account balance;
        double newAcctBal = currBal + depositAmt;
        // set new balance;
        accountEntity.setAccountBalance(newAcctBal);
        accountEntity.setTransactionEntity(transactionSet);
        //save new balance into db
        accountsRepository.save(accountEntity);
        return accountEntity;
    }


    // withdraw money from account
//andy method
    public AccountsEntity withdraw(TransactionsEntity transactionEntity, Integer accountID) {
        // withdraw amt
        double withdrawAmt = transactionEntity.getAmount();
        // retrieve account from db
        AccountsEntity accountEntity = accountsRepository.findById(accountID).get();
        Set<TransactionsEntity> transactionSet = new HashSet<TransactionsEntity>();
        // retrieve user id using accountentity
        UsersEntity usersEntity = usersRepository.findById(accountEntity.getUserID()).get();
        // System.out.println(usersEntity);
        TransactionsEntity newTransaction = new TransactionsEntity();
        newTransaction.setTransactionDate(transactionEntity.getTransactionDate());
        newTransaction.setTransactionNote(transactionEntity.getTransactionNote());
        newTransaction.setTransactionType(transactionEntity.getTransactionType());
        newTransaction.setAmount(transactionEntity.getAmount());
        // saves account entity to transaction
        newTransaction.setAccountsEntity(accountEntity);
        // saves user entity to transaction
        newTransaction.setUsersEntity(usersEntity);
        // save new transaction to transaction table
        transactionsRepository.save(newTransaction);
        transactionSet.add(newTransaction);
        // current account balance;
        double currBal = accountEntity.getAccountBalance();
        // new account balance;
        double newAcctBal = currBal - withdrawAmt;
        // set new balance;
        accountEntity.setAccountBalance(newAcctBal);
        accountsRepository.save(accountEntity);
        return accountEntity;
    }

    //colleen method
    public AccountsEntity withdraw(TransactionsEntity transactionEntity) {
        AccountsEntity accountEntity = accountsRepository.findById(transactionEntity.getAccountID()).get();    
        if(transactionEntity.getAmount() > accountEntity.getAccountBalance()) {
        	throw new SpringBankingAPIException("Withdrawal amount cannot exceed balance");
        }else {
        accountEntity.setAccountBalance(accountEntity.getAccountBalance()-transactionEntity.getAmount());
        transactionEntity.setAccountID(accountEntity.getAccountID());
        transactionEntity.setUserID(accountEntity.getUserID());
        transactionsRepository.save(transactionEntity);
        Set<TransactionsEntity> transactionSet = accountEntity.getTransactionEntity();
        transactionSet.add(transactionEntity);
        accountEntity.setTransactionEntity(transactionSet);
        accountsRepository.save(accountEntity);   
        return accountEntity;
        }
      
    }
    
    //colleen method
    public AccountsEntity deposit(TransactionsEntity transactionEntity) {
    	transactionEntity.getAccountID();
        AccountsEntity accountEntity = accountsRepository.findById(transactionEntity.getAccountID()).get();
        Set<TransactionsEntity> transactionSet = accountEntity.getTransactionEntity();
        accountEntity.setAccountBalance(accountEntity.getAccountBalance()+transactionEntity.getAmount());
        transactionEntity.setAccountID(accountEntity.getAccountID());
        transactionEntity.setUserID(accountEntity.getUserID());
        transactionsRepository.save(transactionEntity);
        transactionSet.add(transactionEntity);
        accountEntity.setTransactionEntity(transactionSet);
        accountsRepository.save(accountEntity);
        return accountEntity;
    }

    //andy & jose & colleen
    public AccountsEntity createAccount(AccountsEntity accountsEntity, Integer userID) {
        // retrieve existing user from database
        UsersEntity usersEntity = usersRepository.findById(userID).get();
        // create new account
//        AccountsEntity accountEntity = new AccountsEntity();
        // set
        Set<AccountsEntity> accountSet = new HashSet<AccountsEntity>();
        // set account balance
//        accountEntity.setUserID(accountsEntity.getUserID());
        // get account type
//        accountEntity.setAccountType(accountsEntity.getAccountType());
        // this will set the foreign key relationship
//        accountEntity.setUsersEntity(usersEntity);
        accountsRepository.save(accountsEntity);
        accountSet.add(accountsEntity);

        System.out.println(accountsEntity);
        usersEntity.setAccountsEntity(accountSet);

        usersRepository.save(usersEntity);
        return accountsEntity;

		// set values for the new account
    	
    	// then add the new account to user
    	
    	// then save/ insert
    	
    }
    

    //Andy & Jose
    private double getDeposit(AccountsEntity accountEntity) {


		double initialDeposit = 0;
		Boolean valid = false;
		while(!valid) {
			
			System.out.print("Please enter initial deposit: ");
			
			try {
				
				initialDeposit = Double.parseDouble(keyboard.next());
				
			}
			catch(NumberFormatException e) {
				
				System.out.println("Deposit must be a number!");
			}
			
			if(accountEntity.getAccountType()=="checking") {
				if(initialDeposit < 100) {
					System.out.println("Checking requires $100 minimum to open");
				} else {
					valid = true;
				}
				
			} else if(accountEntity.getAccountType()=="savings") {
				if(initialDeposit < 50) {
					System.out.println("Saving requires $50 minimum to open");
				} else {
					valid = true;
				}
				
		}
		}
		return initialDeposit;
	}
    
    
}

//accountEntity.setAccountBalance(accountsEntity.getAccountBalance());
//accountEntity.setAccountType(accountsEntity.getAccountType());
//usersEntity.setAccountsEntity(accountEntity);
//if(account_type.equalsIgnoreCase("checking")) {
//	System.out.println("works");
////	accountEntity = new Checking(initialDeposit);
//} 
//else if(account_type.equalsIgnoreCase("savings")){
//	System.out.println("works");
////	accountEntity = new Savings(initialDeposit);
//
//} 
