package com.projectthree.springbanking.accounts;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Integer> {

}
