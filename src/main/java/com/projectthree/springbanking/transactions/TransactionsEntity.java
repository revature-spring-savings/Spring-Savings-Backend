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
	private String transactionType;
	@Column(name="transaction_note")
	private String transactionNote;
	//deposit, withdrawal, transfer
														//source_account and dest_account are nullable
	
	//all income transactions are transactions where dest_account == current account
	//all expense transactions are transactions where source_account == current account
	
	//if source_account has value but dest_account is null, that means it is a withdrawal
	
	
	

}
