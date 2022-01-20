package com.projectthree.springbanking.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UsersEntity, Integer>{
	
   List<UsersEntity> findByEmail(String email);
}
