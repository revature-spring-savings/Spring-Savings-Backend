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
	@Column
	private double amount;
	@Column(name="transaction_date")
	private String transactionDate;
	@Column(name="source_account")
	private int sourceAccount;
	@Column(name="dest_account")
	private int destAccount;
	
	
	

}
