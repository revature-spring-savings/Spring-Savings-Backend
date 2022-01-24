//package com.projectthree.springbanking.accounts;
//
//import com.projectthree.springbanking.transactions.TransactionsEntity;
//import com.projectthree.springbanking.transactions.TransactionsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/accounts")
//@CrossOrigin("*")
//public class AccountsController {
//	
////	@Autowired
////	private AccountsService as;
////	
////	@Autowired
////	private AccountsRepository ar;
//
//	@Autowired
//	private TransactionsRepository tr;
//
//	// error handling
//	@PutMapping("/deposit/{id}")
//	public void depositBal(@PathVariable(value="id") Integer acctID, @RequestBody TransactionsEntity transactionEntity) {
//		as.deposit(transactionEntity, acctID);
//	}
//
//	// just needs error handling
//	@PutMapping("/withdraw/{id}")
//	public void withdrawBal(@PathVariable(value="id") Integer acctID, @RequestBody TransactionsEntity transactionEntity) {
//		as.withdraw(transactionEntity, acctID);
//	}
//
//	@PostMapping("createAccount/{id}")
//	public void testCreateAccount(@PathVariable(value="id") Integer userID, @RequestBody AccountsEntity accountsEntity) {
//		System.out.println("TESTS" + accountsEntity);
//		as.createAccount(accountsEntity, userID);
//	}
//}
