package com.projectthree.springbanking.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {
	
	@Autowired
	private UsersService us;
	
	@Autowired
	private UsersRepository ur;

}
