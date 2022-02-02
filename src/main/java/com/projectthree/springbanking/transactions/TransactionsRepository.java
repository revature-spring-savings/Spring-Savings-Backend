package com.projectthree.springbanking.transactions;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectthree.springbanking.accounts.AccountsEntity;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Integer>{

	List<TransactionsEntity> findAllByAccountID(Integer accountID);

	List<TransactionsEntity> findByUserID(Integer userID);

}

