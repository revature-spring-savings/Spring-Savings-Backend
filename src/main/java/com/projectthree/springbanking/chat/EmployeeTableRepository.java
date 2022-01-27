package com.projectthree.springbanking.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeTableRepository extends JpaRepository<EmployeeTable, Integer>{
	
 List<EmployeeTable> findAll();
//	Optional<AccountsEntity> findById(Integer accountID);
//	List<AccountsEntity> findByuserID(Integer userID);
//
//	Optional<AccountsEntity> findByAccountID(Integer accountID);

}