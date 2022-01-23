package com.projectthree.springbanking.users;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <UsersEntity, Integer>{
	public UsersEntity findByuserID(Integer userID);
	public UsersEntity findByusername(String username);
	public UsersEntity findByEmail(String email);
<<<<<<< HEAD
=======

>>>>>>> 1780fe16d12105199754961fa0e6e2ba8186f530


}