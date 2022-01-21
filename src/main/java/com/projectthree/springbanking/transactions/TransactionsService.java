package com.projectthree.springbanking.transactions;

import java.util.List;

import com.projectthree.springbanking.accounts.AccountsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository tr;
	public TransactionsEntity t;

	//Jeremy
	public List<TransactionsEntity> getAllWithdrawalTransactions() {

		return null;
	}
	
	//Jeremy
//	public List<TransactionsEntity> getAllDepositTransactions(Integer accountID) {
//		AccountsEntity accountEntity = accountsRepository.findById(accountID).get();
//		return null;
//	}

	public TransactionsEntity newTransaction(TransactionsEntity t) {
		// create new transaction here
		return null;
	}

	public TransactionsEntity newTransfer(TransactionsEntity t1, TransactionsEntity t2) {
		//create new transfer here
		return null;
	}

	// transfer between accounts
	// should create two transactions // withdraw from one account and deposit into another account
	// should take in user id and all accounts they own
	// if transfer withdraw from account 1
	// then deposit to account 2
	// should show transaction type


	

}
