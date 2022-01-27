package com.projectthree.springbanking.chat;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectthree.springbanking.accounts.AccountsEntity;

@RestController
@CrossOrigin("*")
@RequestMapping("/chat")
public class ChatController {
 
	@Autowired
	UserTableRepository userRepo;
	
	@Autowired
	EmployeeTableRepository empRepo;
	
	@PostMapping("/user/{username}")
	public void addUserToTable(@PathVariable String username) {
		
		UserTable newUser = new UserTable(username);
		System.out.println("username ********" + newUser);
		userRepo.save(newUser);
	}
	
	@PostMapping("/employee/{employeeUsername}")
	public void addEmployeeToTable(@PathVariable String employeeUsername) {
		
		EmployeeTable newEmployee = new EmployeeTable(employeeUsername);
		
		empRepo.save(newEmployee);
	}
	
	//testing 
	@GetMapping("/employee/allEmployee")
	public List<EmployeeTable> getEmployeeFromTable() {
		
		return empRepo.findAll();
	}
	
	@GetMapping("/user/allUser")
	public List<UserTable> getUserFromTable() {
		
		return userRepo.findAll();
	}
	
	@PostMapping("/user/remove")
	public void removeUserFromTable() {
		
		List<UserTable> list = userRepo.findAll();
		UserTable temp = list.get(0);
//		System.out.println("temp++++++" + temp.getId());
		userRepo.deleteById(temp.getId());
		
	}
	
	@PostMapping("/employee/remove")
	public void removeEmployeeFromTable() {
		
		List<EmployeeTable> list = empRepo.findAll();
		EmployeeTable temp = list.get(0);
//		System.out.println("temp++++++" + temp.getId());
		empRepo.deleteById(temp.getId());
		
	}
}
