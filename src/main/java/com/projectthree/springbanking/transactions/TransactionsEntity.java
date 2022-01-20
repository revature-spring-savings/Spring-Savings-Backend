package com.projectthree.springbanking.transactions;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="transactions")
public class TransactionsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	

	
	
	

}
