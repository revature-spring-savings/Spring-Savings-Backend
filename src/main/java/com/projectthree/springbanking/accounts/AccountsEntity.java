package com.projectthree.springbanking.accounts;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude= {"usersEntity", "transactionEntity"})
@Entity
@Table(name="accounts")
public class AccountsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private Integer accountID;
	@Column(name="account_type")
	private String accountType;
	@Column(name="account_balance")
	private double accountBalance;

	@ToString.Exclude
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonBackReference
	private UsersEntity usersEntity;
	//colleen made a change

	// owner side of relationship
	// accounts can have multiple relationships
	@ToString.Exclude
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy="accountsEntity", cascade = CascadeType.ALL)
	private Set<TransactionsEntity> transactionEntity;
}
