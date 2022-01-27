package com.projectthree.springbanking.transactions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude="usersEntity")
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="transactions")
public class TransactionsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private int transactionID;
	@Column
	private double amount;
	@Column(name="user_id")
	private Integer userID;
	@Column(name="account_id")
	private Integer accountID;
	@Column(name="transaction_date")
	private String transactionDate;
	@Column(name="transaction_type")
	private String transactionType;  // DEPOSIT or WITHDRAW
	@Column(name="transaction_note")
	private String transactionNote; // paycheck from Revature OR electricity bill OR transfer from acct 1 to acct 2

	//@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName="user_id", nullable=false, insertable=false, updatable=false)
	@JsonIgnore
	@ToString.Exclude
	private UsersEntity usersEntity;

	//@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "account_id", referencedColumnName="account_id", nullable=false, insertable=false, updatable=false)
	@JsonIgnore
	@ToString.Exclude
	private AccountsEntity accountsEntity;
	// a transfer creates two Transactions: one deposit and one withdrawal
}