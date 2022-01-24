package com.projectthree.springbanking.users;

import com.projectthree.springbanking.accounts.AccountsEntity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
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
	
	@GetMapping("/addtest")
	public String makeUser() {
		UsersEntity u = new UsersEntity();	
		ur.save(u);
		return "hello";
	}
	
	@PostMapping("/login")
        public UsersEntity userLogin(@RequestBody UsersEntity user) {
		logger.info(user.getUsername());
		return us.userLogin(user);
        } 
	
	@PostMapping("/register")
	public UsersEntity createUser(@RequestBody UsersEntity user) {
		return us.register(user);
	}
	
	
	@GetMapping("/id/{id}")
	public UsersEntity findByID(@PathVariable Integer userID) {
		return us.findByID(userID);
	}
	
	@GetMapping("/username/{username}")
	public UsersEntity getUserbyUsername(@PathVariable String username) {
		return us.findByUsername(username);
	}
	
	@PutMapping("/update/")
	public String updateUserInfo(@RequestBody UsersEntity user) {
		return us.updateUser(user);
	}
}
