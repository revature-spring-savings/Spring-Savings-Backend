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
				return ar.findAllByID(userID);
		
//		userService.findById(userID);
		
	}
	
	@GetMapping("/{accountID}")
	public AccountsEntity userAccountByID(@PathVariable Integer accountID){
	//	Optional<AccountsEntity> o = as.accountByID(accountID);
	//	AccountsEntity a = o.get();
		// return a;
		return ar.findById(accountID).get();
	}

}
