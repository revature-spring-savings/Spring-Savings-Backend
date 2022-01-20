package com.projectthree.springbanking.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
			
			@Autowired
				private UserRepository userRep;
		
			
			public List<UsersEntity> getUserByEmail(String email){
				return userRep.findByEmail(email);

			}
	
	
}
