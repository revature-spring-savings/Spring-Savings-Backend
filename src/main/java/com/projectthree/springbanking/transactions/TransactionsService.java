package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository tr;
	public TransactionsEntity t;

	//Jeremy
	public List<TransactionsEntity> getAllWithdrawalTransactions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Jeremy
	public List<TransactionsEntity> getAllDepositTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

}
