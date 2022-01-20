package com.projectthree.springbanking.accounts;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

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

	//
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UsersEntity usersEntity;




    @OneToMany(fetch = FetchType.LAZY, mappedBy="accountsEntity", cascade = CascadeType.ALL)
    private Set<TransactionsEntity> transactionEntity;
}
