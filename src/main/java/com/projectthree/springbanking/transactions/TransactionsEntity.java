package com.projectthree.springbanking.transactions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	private Integer transactionID;
//	@Column(name="user_id")
//	private int userID;
//	@Column(name="account_id")
//	private int accountID;
	@Column
	private double amount;
	@Column(name="transaction_date")
	private String transactionDate;
	@Column(name="transaction_type")
	private String transactionType;  // DEPOSIT or WITHDRAW
	@Column(name="transaction_note")
	private String transactionNote; // paycheck from Revature OR electricity bill OR transfer from acct 1 to acct 2

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	@ToString.Exclude
	private UsersEntity usersEntity;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="account_id")
	@JsonBackReference
	@ToString.Exclude
	private AccountsEntity accountsEntity;
	// a transfer creates two Transactions: one deposit and one withdrawal
}
