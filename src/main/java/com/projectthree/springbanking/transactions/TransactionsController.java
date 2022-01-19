package com.projectthree.springbanking.transactions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping
	public List<TransactionsEntity> getAllTransactions() {
		return tr.findAll();
	}
	
	@GetMapping("id/{id}")
	public TransactionsEntity getOneTransaction(@PathVariable Integer id) {
		return tr.getById(id);
	}
	
//	@PostMapping
//	public TransactionsEntity createNewTransaction(@RequestBody TransactionsEntity t){	
//		return ts.newTransaction(t);	
//	}
	
	@PostMapping
	public TransactionsEntity createNewTransaction(@RequestBody List<TransactionsEntity> l){	
		if(l.size() == 1) {
			return ts.newTransaction(l.get(0));	
		}else if(l.size()==2){
			return ts.newTransfer(l.get(0), l.get(1));			
		}else {
			return null;
		}
		
	}
	
//	@GetMapping("withdraw")
//	public List<TransactionsEntity> getAllWithdrawalTransactions() {
//		return ts.getAllWithdrawalTransactions();
//	}
//	
//	@GetMapping("deposit")
//	public List<TransactionsEntity> getAllDepositTransactions() {
//		return ts.getAllTransactions();
//	}
	
//	@PostMapping("transfer")
//	public List<TransactionsEntity> getAllDepositTransactions() {
//		return ts.getAllTransactions();
//	}
	
	
	

}
