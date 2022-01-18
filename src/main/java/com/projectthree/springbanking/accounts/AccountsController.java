package com.projectthree.springbanking.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
