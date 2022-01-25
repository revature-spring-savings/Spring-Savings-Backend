package com.projectthree.springbanking.users;

import com.projectthree.springbanking.accounts.AccountsEntity;

import java.util.List;

import com.projectthree.springbanking.exception.SpringBankingServerException;

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
		if (ur.findAll().isEmpty() || ur.findAll().size() <= 0) {
			throw new SpringBankingServerException("Could not retrieve a list of users");
		}
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

	@GetMapping("/username/{username}")
	public UsersEntity getUserbyUsername(@PathVariable String username) {
		return us.findByUsername(username);
	}
	
	@GetMapping("/id/{id}")
	public UsersEntity findByID(@PathVariable Integer userID) {

		return us.findByID(userID);
	}

	@PutMapping("/update/")
	public String updateUserInfo(@RequestBody UsersEntity user) {
		return us.updateUser(user);
  }
}
