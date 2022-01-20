package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Integer>{
	
//	@Query("SELECT * FROM transactions WHERE account_id = 1")
//    List<TransactionsEntity> findAllByAccountId();
}
