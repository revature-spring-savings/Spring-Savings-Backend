package com.projectthree.springbanking.users;

import com.projectthree.springbanking.accounts.AccountsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {
	
	@Autowired
	private UsersService us;
	

}
