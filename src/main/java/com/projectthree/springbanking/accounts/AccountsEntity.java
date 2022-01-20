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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
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
	@Column(name="user_id" , insertable=false, updatable=false )
	private Integer userID;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy="accountsEntity", cascade = CascadeType.ALL)
	private Set<TransactionsEntity> transactionEntity;
}
