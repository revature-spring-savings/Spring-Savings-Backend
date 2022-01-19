package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionsService {

<<<<<<< HEAD
	
=======
>>>>>>> 0049b619c80797510a142b6c2c73354e41ad0679
	@Autowired
	private TransactionsRepository tr;
	public TransactionsEntity transaction;
	
	
	public List<TransactionsEntity> getAllTransactions() {
		return tr.findAll();	
	}

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
	
<<<<<<< HEAD
=======

>>>>>>> 0049b619c80797510a142b6c2c73354e41ad0679

}
