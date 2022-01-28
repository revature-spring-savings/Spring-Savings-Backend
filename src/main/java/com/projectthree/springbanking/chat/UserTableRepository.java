package com.projectthree.springbanking.chat;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectthree.springbanking.accounts.AccountsEntity;


@Repository
public interface UserTableRepository extends JpaRepository<UserTable, Integer>{
	
	List<UserTable> findAll();
//	Optional<AccountsEntity> findById(Integer accountID);
//	List<AccountsEntity> findByuserID(Integer userID);
//
//	Optional<AccountsEntity> findByAccountID(Integer accountID);

}

