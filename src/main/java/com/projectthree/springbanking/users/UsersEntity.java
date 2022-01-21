package com.projectthree.springbanking.users;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude="usersEntity")
@Entity
@Table(name="users")
public class UsersEntity {
<<<<<<< .merge_file_a14348
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
=======

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
>>>>>>> .merge_file_a20220
    @Column(name="user_id")
    private Integer userID;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="username")
    private String username;
    @Column(name="pass")
    private String pass;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="dob")
    private String dob;
    @Column(name="user_role")
    private String userRole;

    // defines owning side of relationship
    // multiple accounts one users
    @OneToMany(fetch = FetchType.LAZY, mappedBy="usersEntity", cascade = CascadeType.ALL)
    private Set<AccountsEntity> accountsEntity; 

   
    

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy="usersEntity", cascade = CascadeType.ALL)
    private Set<TransactionsEntity> transactionsEntity;
}

