package com.projectthree.springbanking.accounts;

import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Integer>{
	
	List<AccountsEntity> findAll();
	Optional<AccountsEntity> findById(Integer accountID);
	List<AccountsEntity> findByuserID(Integer userID);

	Optional<AccountsEntity> findByAccountID(Integer accountID);

}
