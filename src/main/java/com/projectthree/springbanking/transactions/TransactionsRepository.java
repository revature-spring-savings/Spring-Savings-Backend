package com.projectthree.springbanking.transactions;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectthree.springbanking.accounts.AccountsEntity;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Integer>{

	List<TransactionsEntity> findByAccountId(Integer accountID);
	
//	@Query("SELECT * FROM transactions WHERE account_id = 1")
//    List<TransactionsEntity> findAllByAccountId();
}
