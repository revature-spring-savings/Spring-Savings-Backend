package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions/")
@CrossOrigin("*")
public class TransactionsController {
	
	@Autowired
	private TransactionsService ts;
	
	@Autowired
	private TransactionsRepository tr;
	//change
	
	@GetMapping
	public List<TransactionsEntity> getAllTransactions() {
		return ts.getAllTransactions();
	}
	
	@GetMapping("withdraw")
	public List<TransactionsEntity> getAllWithdrawalTransactions() {
		return ts.getAllWithdrawalTransactions();
	}
	
	@GetMapping("deposit")
	public List<TransactionsEntity> getAllDepositTransactions() {
		return ts.getAllTransactions();
	}
	
	
	

}
