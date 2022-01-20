package com.projectthree.springbanking.transactions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Integer>{

}
