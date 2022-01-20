package com.projectthree.springbanking.users;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <UsersEntity, Integer>{
	
	public UsersEntity findByUsername(String username);
	public UsersEntity findByEmail(String email);


}
