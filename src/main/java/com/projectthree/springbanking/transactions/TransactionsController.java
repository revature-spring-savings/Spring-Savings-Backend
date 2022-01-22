package com.projectthree.springbanking.transactions;

import java.util.List;
import java.util.NoSuchElementException;

import com.projectthree.springbanking.exception.SpringBankingAPIException;
import com.projectthree.springbanking.exception.SpringBankingServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.accounts.AccountsService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
public class TransactionsController {

	@Autowired
	private TransactionsService ts;
	
	@Autowired
	private AccountsService as;

	@Autowired
	private TransactionsRepository tr;

	@GetMapping
	public List<TransactionsEntity> getAllTransactions() {
		if (tr.findAll().size() <= 0) {
			throw new SpringBankingServerException("Could not retrieve transactions from server");
		}
		return tr.findAll();
	}

	@GetMapping("/id/{id}")
	public TransactionsEntity getOneTransaction(@PathVariable Integer id) {
		System.out.println(tr.getById(id));
		return tr.getById(id);
	}

	@PostMapping
	public List<TransactionsEntity> createNewTransaction(@RequestBody List<TransactionsEntity> l) {
		if (l.size() == 1) {
	//		tr.save(l.get(0));
			if(l.get(0).getTransactionType().equals("WITHDRAW")) {
				as.withdraw(l.get(0));
			}else {
				as.withdraw(null);
			}
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
	
//	@PostMapping("/transfer")
//	public List<TransactionsEntity> getAllDepositTransactions(@RequestBody List<TransactionsEntity> transactionsEntity) {
//		ts.transferAccounts(transactionsEntity);
//		return ts.getAllTransactions();
//	}
	
	@DeleteMapping("/id/{id}")
	public String deleteOneTransaction(@PathVariable Integer id) {
		if (id == 0) {
			throw new SpringBankingAPIException("Please enter an transaction id greater than 0");
		}
		if (tr.findAllByAccountID(id).isEmpty()) {
			throw new NoSuchElementException("Could not find transaction with id:" + " " + id);
		}
		 tr.deleteById(id);
		 return "done";
	}
}
