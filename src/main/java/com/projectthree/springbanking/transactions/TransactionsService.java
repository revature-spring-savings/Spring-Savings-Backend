package com.projectthree.springbanking.transactions;

import java.util.List;


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

	//Jeremy
	public List<TransactionsEntity> getAllWithdrawalTransactions(Integer accountID) {
		// get request to see all withdraw from one user
		// get by account type

        AccountsEntity accountEntity = accountsRepository.findById(accountID).get();
//        tr.findAllByAccountId();
//		if(accountEntity.getAccountType().equals("withdraw")) {
//			//come back here
//		}
		
        // Grouped by withdraw
		
        
		return null;
	}
	
	//Jeremy
	public List<TransactionsEntity> getAllDepositTransactions(Integer accountID) {
		// get request to see all deposts from one user
		// Grouped by account type
        AccountsEntity accountEntity = accountsRepository.findById(accountID).get();

		// Grouped by deposit
		
		return null;
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
