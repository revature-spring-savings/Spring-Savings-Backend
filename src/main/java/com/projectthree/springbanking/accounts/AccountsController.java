package com.projectthree.springbanking.accounts;

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
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountsController {
	
	@Autowired
	private AccountsService as;
	
	@Autowired
	private AccountsRepository ar;
	
	@GetMapping("/{userID}/all-accounts")
	public List <AccountsEntity> userAccounts(@PathVariable Integer userID){
				return ar.findByuserID(userID);
		
//		userService.findById(userID);
		
	}
	
	@GetMapping("/{accountID}")
	public AccountsEntity userAccountByID(@PathVariable Integer accountID){
	//	Optional<AccountsEntity> o = as.accountByID(accountID);
	//	AccountsEntity a = o.get();
		// return a;
		return ar.findById(accountID).get();
	}

	@Autowired
	private TransactionsRepository tr;

	
	@GetMapping
	public List<AccountsEntity> getAllAccounts() {
		return ar.findAll();
	}
	// error handling
	@PutMapping("/deposit/{id}")
	public void depositBal(@PathVariable(value="id") Integer acctID, @RequestBody TransactionsEntity transactionEntity) {
		as.deposit(transactionEntity, acctID);
	}

	// just needs error handling
	@PutMapping("/withdraw/{id}")
	public void withdrawBal(@PathVariable(value="id") Integer acctID, @RequestBody TransactionsEntity transactionEntity) {
		as.withdraw(transactionEntity, acctID);
	}

	@PostMapping("createAccount/{id}")
	public void testCreateAccount(@PathVariable(value="id") Integer userID, @RequestBody AccountsEntity accountsEntity) {
		System.out.println("TESTS" + accountsEntity);
		as.createAccount(accountsEntity, userID);
	}
}
