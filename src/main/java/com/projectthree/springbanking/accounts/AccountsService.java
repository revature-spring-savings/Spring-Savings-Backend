package com.projectthree.springbanking.accounts;


import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersRepository;

import java.util.HashSet;
import java.util.Set;

import com.projectthree.springbanking.transactions.TransactionsRepository;
import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

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

    public UsersEntity createAccount(AccountsEntity accountsEntity, Integer userID) {
        // retrieve existing user from database
        UsersEntity usersEntity = usersRepository.findById(userID).get();
        // create new account
        AccountsEntity accountEntity = new AccountsEntity();
        // set
        Set<AccountsEntity> accountSet = new HashSet<AccountsEntity>();
        // set account balance
        accountEntity.setAccountBalance(accountsEntity.getAccountBalance());
        // get account type
        accountEntity.setAccountType(accountsEntity.getAccountType());
        // this will set the foreign key relationship
        accountEntity.setUsersEntity(usersEntity);
        accountsRepository.save(accountEntity);
        accountSet.add(accountEntity);

        System.out.println(accountEntity);
        usersEntity.setAccountsEntity(accountSet);

        usersRepository.save(usersEntity);
        return usersEntity;
        }
    }
