package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository tr;
	public TransactionsEntity t;

	// Gets all transactions by account ID => filtering done on the frontend React
	public List<TransactionsEntity> getAllTransactionsByAccountID(Integer accountID) {     
		return tr.findAllByAccountID(accountID);
	}


}
