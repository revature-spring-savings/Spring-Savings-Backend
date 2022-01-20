package com.projectthree.springbanking.users;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {
	
	static Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersService us;
	
	@Autowired
	private UsersRepository ur;
	
	
	
	@GetMapping
	public List<UsersEntity> retrieveAllUsers(){
		logger.trace("Current Users");
		return  ur.findAll();
	}
	
	
	@PostMapping("/login")
    public UsersEntity userLogin(@RequestBody UsersEntity user) {
		logger.info(user.getUsername());
		return us.userLogin(user.getUsername(), user.getPass());
    } 
	
	@PostMapping("/register")
	public UsersEntity createUser( @RequestBody UsersEntity user) {
		return us.register(user);
	}
	
	
	@GetMapping("/id/{id}")
	public UsersEntity findByID(@PathVariable Integer userId) {
		return us.getByID(userId);
	}
	
	@GetMapping("/username/{username}")
	public UsersEntity getUserbyUsername(@PathVariable String username) {
		return us.getByUsername(username);
	}
	
	@PutMapping("/update/")
	public String updateUserInfo(@RequestBody UsersEntity user) {
		return us.updateUser(user);
	}
	
	
	

}
