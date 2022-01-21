package com.projectthree.springbanking.users;

import com.projectthree.springbanking.accounts.AccountsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {
	
	@Autowired
	private UsersService us;
	
	@Autowired
	private UsersRepository ur;

	@GetMapping
	public List<UsersEntity> getAllUsers() {
		return ur.findAll();
	}

}
