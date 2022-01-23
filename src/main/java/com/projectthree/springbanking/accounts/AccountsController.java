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
import com.projectthree.springbanking.exception.SpringBankingAPIException;
import com.projectthree.springbanking.exception.SpringBankingException;
import com.projectthree.springbanking.exception.SpringBankingServerException;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsRepository;

import java.util.List;
import java.util.NoSuchElementException;

import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersRepository;
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

	@Autowired
	private TransactionsRepository tr;

	@Autowired
	private UsersRepository usersRepository;


	@GetMapping("/{userID}/all-accounts")
	public List <AccountsEntity> userAccounts(@PathVariable Integer userID){
		if (!ar.findByAccountID(userID).isPresent() || userID < 0) {
			throw new NoSuchElementException("User with id: " + userID + " does not exist!");
		}
				return ar.findByuserID(userID);
		
//		userService.findById(userID);
		
	}
	
	@GetMapping("/{accountID}")
	public AccountsEntity userAccountByID(@PathVariable Integer accountID){
		if (!ar.findById(accountID).isPresent() || accountID < 0) {
			throw new NoSuchElementException("Account with id: " + accountID + " does not exist!");
		}
	//	Optional<AccountsEntity> o = as.accountByID(accountID);
	//	AccountsEntity a = o.get();
		// return a;
		return ar.findById(accountID).get();
	}
	
	@GetMapping
	public List<AccountsEntity> getAllAccounts() {
		ar.findAll();
		if (ar.findAll().size() <= 0 || ar.findAll().isEmpty()) {
			throw new SpringBankingServerException("Could not retrieve accounts from server");
		}
		return ar.findAll();
	}

	@PutMapping("/deposit/{id}")
	public AccountsEntity depositBal(@PathVariable(value="id") Integer acctID, @RequestBody TransactionsEntity transactionEntity) {
		if (!ar.findById(acctID).isPresent()) {
			throw new NoSuchElementException("Could not deposit into account since account ID: " + acctID + " does not exist");
		}
		AccountsEntity ac = ar.findById(acctID).get();
		as.deposit(transactionEntity, acctID);
		return ac;
	}

	@PutMapping("/withdraw/{id}")
	public AccountsEntity withdrawBal(@PathVariable(value="id") Integer acctID, @RequestBody TransactionsEntity transactionEntity) {
		if (!ar.findById(acctID).isPresent()) {
			throw new NoSuchElementException("Could not withdraw from account since account ID does not exist");
		}
		AccountsEntity ac = ar.findById(acctID).get();
		as.withdraw(transactionEntity, acctID);
		return ac;
	}

	@PostMapping("createAccount/{id}")
	public void CreateAccount(@PathVariable(value="id") Integer userID, @RequestBody AccountsEntity accountsEntity) {
		if (!usersRepository.findById(userID).isPresent()) {
			throw new NoSuchElementException("Could not find existing user with id: " + userID);
		};

		as.createAccount(accountsEntity, userID);
	}
}
