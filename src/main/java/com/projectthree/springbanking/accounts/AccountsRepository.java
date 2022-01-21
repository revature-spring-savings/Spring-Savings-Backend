package com.projectthree.springbanking.accounts;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Integer> {

	Optional<AccountsEntity> findByAccountID(Integer accountID);

}
