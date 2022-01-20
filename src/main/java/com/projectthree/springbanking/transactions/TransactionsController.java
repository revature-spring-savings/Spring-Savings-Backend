package com.projectthree.springbanking.transactions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping
	public List<TransactionsEntity> getAllTransactions() {
		return tr.findAll();
	}
	
	@GetMapping("/id/{id}")
	public TransactionsEntity getOneTransaction(@PathVariable Integer id) {
		return tr.getById(id);
	}
	
	@PostMapping
	public String createNewTransaction(@RequestBody List<TransactionsEntity> l){	
		System.out.println(l);
		System.out.println(l.size());
		if(l.size() == 1) {
			tr.save(l.get(0));
			return "one";
		}else if(l.size()==2){
			tr.save(l.get(0));
			tr.save(l.get(1));
			return "two";			
		}else {
			return "none";
		}		
	}
	
	@DeleteMapping("/id/{id}")
	public String deleteOneTransaction(@PathVariable Integer id) {
		tr.deleteById(id);
		return "done";
	}
	
	
	

}
