package com.projectthree.springbanking.accounts;

import javax.persistence.*;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="accounts")
public class AccountsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private Integer accountID;
	@Column(name="account_type")
	private String accountType;
	@Column(name="account_balance")
	private double accountBalance;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UsersEntity usersEntity;
	//colleen made a change

	// owner side of relationship
	// accounts can have multiple relationships
	@OneToMany(fetch = FetchType.LAZY, mappedBy="accountsEntity", cascade = CascadeType.ALL)
	private Set<TransactionsEntity> transactionEntity;
}
