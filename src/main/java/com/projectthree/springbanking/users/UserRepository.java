package com.projectthree.springbanking.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Integer>{
	
boolean findById(int id);
	
}
