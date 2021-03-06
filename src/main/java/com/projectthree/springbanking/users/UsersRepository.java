package com.projectthree.springbanking.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    public UsersEntity findByuserID(Integer userID);
    public UsersEntity findByusername(String username);
    public UsersEntity findByEmail(String email);
}