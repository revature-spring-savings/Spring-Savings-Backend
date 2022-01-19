package com.projectthree.springbanking.users;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table  (name = "users")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;
	@Column(name = "pass")
	private String pass;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "dob")
	private String dob;
	@Column(name = "user_role")
	private String userRole;
	
	
	
}
