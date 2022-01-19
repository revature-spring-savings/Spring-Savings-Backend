package com.projectthree.springbanking.transactions;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="transactions")
public class TransactionsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private int transactionID;
	@Column(name="user_id")
	private int userID;
	@Column(name="account_id")
	private int accountID;
	@Column
	private double amount;
	@Column(name="transaction_date")
	private String transactionDate;
	@Column(name="transaction_type")
	private String transactionType;  // DEPOSIT or WITHDRAW
	@Column(name="transaction_note")
	private String transactionNote; // paycheck from Revature OR electricity bill OR transfer from acct 1 to acct 2 
	
	// a transfer creates two Transactions: one deposit and one withdrawal
	
	
	

}
