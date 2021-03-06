
package com.projectthree.springbanking.transactions;

import java.util.ArrayList;
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
import com.projectthree.springbanking.accounts.AccountsRepository;
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

	@Autowired
	private AccountsRepository ar;
	
	TransactionsEntity t;
	List<TransactionsEntity> tl;
//	List<AccountsEntity> al = new ArrayList<AccountsEntity>();

	@GetMapping
	public List<TransactionsEntity> getAllTransactions() {
		tl = tr.findAll();
		if (tl.size() <= 0) {
			throw new SpringBankingServerException("Could not retrieve transactions from server");
		}
		return tl;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/id/{transactionID}")
	public TransactionsEntity getOneTransaction(@PathVariable Integer transactionID) {
		t = tr.getById(transactionID);
		if (t == null) {
			throw new SpringBankingServerException("Could not retrieve transaction from server");
		}
		return t;
	}

	@PostMapping
	public List<AccountsEntity> createNewTransaction(@RequestBody List<TransactionsEntity> l) {
		List<AccountsEntity> al = new ArrayList<AccountsEntity>();
		if (l.size() == 1) { //just deposit or withdrawal
				System.out.println("size is 1");
				System.out.println("type is "+l.get(0).getTransactionType());
			if (!ar.findById(l.get(0).getAccountID()).isPresent()) {
				System.out.println("found the error");
				throw new NoSuchElementException("Could not perform transaction because account ID does not exist");
			}
			
			if (l.get(0).getTransactionType().equals("WITHDRAW")) {
				al.add(as.withdraw(l.get(0)));
			} else {
				System.out.println("i reached else");
				al.add(as.deposit(l.get(0)));
			}
			return al;
		} else if (l.size() == 2) { //transfer
			if (!ar.findById(l.get(0).getAccountID()).isPresent() || !ar.findById(l.get(1).getAccountID()).isPresent()) {
				throw new NoSuchElementException("Could not transfer to account "+l.get(1).getAccountID() +" because it does not exist");
			}

			if (l.get(0).getTransactionType().equals("WITHDRAW")) {
				al.add(as.withdraw(l.get(0)));
				al.add(as.deposit(l.get(1)));
			} else { //something funky
				al.add(as.withdraw(l.get(1)));
				al.add(as.deposit(l.get(0)));
			}

			if (l.get(0) == null || l.get(1) == null) {
				return null;
			} else {
				return al;
			}
		}
		return null;

	}

		//get withdrawals by accountID
	@PostMapping("/withdraw")
	public List<TransactionsEntity> getAllWithdrawalTransactions(@RequestBody AccountsEntity a) {
		if (ts.getAllTransactionsByAccountID(a.getAccountID()).size() == 0) {
			throw new SpringBankingServerException("Could not retrieve accounts or withdraw transactions do not exist..");
		}
		return ts.getAllTransactionsByAccountID(a.getAccountID());
	}

	//get deposits by accountID
	@PostMapping("/deposit")
	public List<TransactionsEntity> getAllDepositTransactions(@RequestBody AccountsEntity a) {
		if (ts.getAllTransactionsByAccountID(a.getAccountID()).size() == 0) {
			throw new SpringBankingServerException("Could not retrieve accounts or deposit transactions do not exist..");
		}
		return ts.getAllTransactionsByAccountID(a.getAccountID());
	}
	
		@GetMapping("/all/{accountID}")
		public List<TransactionsEntity> getAllDepositTransactions(@PathVariable Integer accountID) {
			return ts.getAllTransactionsByAccountID(accountID);
		}
		

		@GetMapping("/userID/{userID}")
		public List<TransactionsEntity> getAllByUserID(@PathVariable Integer userID) {
			return tr.findByUserID(userID);
		}
		
		@GetMapping("/accountID/{accountID}")
		public List<TransactionsEntity> getAllByAccountID(@PathVariable Integer accountID) {
			System.out.println( tr.findAllByAccountID(accountID));
			
			return tr.findAllByAccountID(accountID);
		}

	@DeleteMapping("/id/{id}")
	public String deleteOneTransaction(@PathVariable Integer id) {
		if (id == 0) {
			throw new SpringBankingAPIException("Please enter an transaction id greater than 0");
		}
		if (!tr.findById(id).isPresent()) {
			throw new NoSuchElementException("Could not find transaction with id:" + " " + id);
		}
		tr.deleteById(id);
		return "done";
	}
}
