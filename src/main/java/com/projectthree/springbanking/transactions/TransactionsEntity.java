package com.projectthree.springbanking.transactions;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.users.UsersEntity;
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
//	@Column(name="user_id")
//	private int userID;
//	@Column(name="account_id")
//	private int accountID;
	@Column
	private double amount;
	@Column(name="transaction_date")
	private String transactionDate;
	@Column(name="transaction_type")
<<<<<<< HEAD
	private String transactionType;  // DEPOSIT or WITHDRAW
	@Column(name="transaction_note")
	private String transactionNote; // paycheck from Revature OR electricity bill OR transfer from acct 1 to acct 2
=======
	private String transactionType;
	@Column(name="transaction_note")
	private String transactionNote;
	

	
	
	
>>>>>>> 0049b619c80797510a142b6c2c73354e41ad0679

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UsersEntity usersEntity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id")
	private AccountsEntity accountsEntity;
	// a transfer creates two Transactions: one deposit and one withdrawal
}
