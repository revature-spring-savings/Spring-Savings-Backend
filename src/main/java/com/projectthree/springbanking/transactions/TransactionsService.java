package com.projectthree.springbanking.transactions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository tr;
	public TransactionsEntity t;

	// Gets all transactions by account ID => filtering done on the frontend React
	public List<TransactionsEntity> getAllTransactionsByAccountID(Integer accountID) {     
		return tr.findAllByAccountID(accountID);
	}
	
	public TransactionsEntity createInitialDeposit(Integer accountID, Integer userID, Double amount) {     
		TransactionsEntity initialDep = new TransactionsEntity();
		initialDep.setAccountID(accountID);
		initialDep.setUserID(userID);
		initialDep.setAmount(amount);
		initialDep.setTransactionDate(today());
		initialDep.setTransactionNote("Initial Deposit");
		initialDep.setTransactionType("DEPOSIT");
		
		tr.save(initialDep);
		System.out.println(initialDep);
		return initialDep;
	}
	
	public String today() {
			Date date = new Date();
	  //    String timeFormatString = "hh:mm:ss a";
	   //   DateFormat timeFormat = new SimpleDateFormat(timeFormatString);
	    //  String currentTime = timeFormat.format(date);
	    //  System.out.println("Current time: "+currentTime);
	      String dateFormatString = "MM/DD/YYYY";
	      DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
	      String currentDate = dateFormat.format(date);
	      System.out.println("Current date: "+currentDate);
	      return currentDate;
	}

}
