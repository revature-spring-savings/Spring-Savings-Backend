package com.projectthree.springbanking.users;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
	@Data
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor 
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