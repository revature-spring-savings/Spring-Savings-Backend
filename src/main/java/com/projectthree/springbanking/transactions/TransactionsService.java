package com.projectthree.springbanking.transactions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.accounts.AccountsRepository;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository tr;
	public TransactionsEntity t;
	
    @Autowired
    private AccountsRepository accountsRepository;

	// Gets all transactions by account ID => filtering done on the frontend React
	public List<TransactionsEntity> getAllTransactionsByAccountID(Integer accountID) {
		
        List<TransactionsEntity> transactionsList = tr.findAllByAccountID(accountID);
        
		return transactionsList;
	}

	public TransactionsEntity newTransaction(TransactionsEntity t) {
		// create new transaction here
		return null;
	}

	public TransactionsEntity newTransfer(TransactionsEntity t1, TransactionsEntity t2) {
		//create new transfer here
		return null;
	}

	public List<TransactionsEntity> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
