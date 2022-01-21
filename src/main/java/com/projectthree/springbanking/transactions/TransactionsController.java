package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectthree.springbanking.accounts.AccountsEntity;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
public class TransactionsController {

	@Autowired
	private TransactionsService ts;

	@Autowired
	private TransactionsRepository tr;

	@GetMapping
	public List<TransactionsEntity> getAllTransactions() {
	//	System.out.println(tr.findAll());
		return tr.findAll();
	}

	@GetMapping("/id/{id}")
	public TransactionsEntity getOneTransaction(@PathVariable Integer id) {
		return tr.getById(id);
	}

	@PostMapping
	public List<TransactionsEntity> createNewTransaction(@RequestBody List<TransactionsEntity> l) {
		if (l.size() == 1) {
			tr.save(l.get(0));
			return l;
		} else if (l.size() == 2) {
			tr.save(l.get(0));
			tr.save(l.get(1));

			return l;
		} else {
			return null;
		}
	}
	
	@PostMapping("/withdraw")
	public List<TransactionsEntity> getAllWithdrawalTransactions(@RequestBody AccountsEntity a) {
		System.out.println(a.getAccountID());
		return ts.getAllTransactionsByAccountID(a.getAccountID());
	}
	
	@GetMapping("/deposit")
	public List<TransactionsEntity> getAllDepositTransactions(@RequestBody AccountsEntity a) {
		return ts.getAllTransactionsByAccountID(a.getAccountID());
	}
	
	@DeleteMapping("/id/{id}")
	public String deleteOneTransaction(@PathVariable Integer id) {
		tr.deleteById(id);
		return "done";
	}
	


//	@PostMapping
//	public String createNewTransaction(@RequestBody List<TransactionsEntity> l){	
//		if(l.size() == 1) {
//			tr.save(l.get(0));
//			return "one";
//		}else if(l.size()==2){
//			tr.save(l.get(0));
//			tr.save(l.get(1));
//			return "two";			
//		}else {
//			return "none";
//		}		
//	}

}
