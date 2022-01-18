package com.projectthree.springbanking.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
public class TransactionsController {
	
	@Autowired
	private TransactionsService ts;
	
	@Autowired
	private TransactionsRepository tr;
	
	

}
