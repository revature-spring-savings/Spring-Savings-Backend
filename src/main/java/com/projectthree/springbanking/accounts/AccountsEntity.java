package com.projectthree.springbanking.accounts;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude= {"usersEntity", "transactionEntity"})
@Entity
@Table(name="accounts")
public class AccountsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private Integer accountID;
	@Column(name="user_id")
	private Integer userID;
	@Column(name="account_type")
	private String accountType;
	@Column(name="account_balance")
	private double accountBalance;

	@ToString.Exclude
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName="user_id", nullable=false, insertable=false, updatable=false)
	@JsonBackReference
	private UsersEntity usersEntity;

	// owner side of relationship
	// accounts can have multiple relationships
	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy="accountsEntity", cascade = CascadeType.ALL)
	private Set<TransactionsEntity> transactionEntity;

}
