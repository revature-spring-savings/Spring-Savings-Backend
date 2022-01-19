package com.projectthree.springbanking.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository ur;
	
	public List<UsersEntity> getAllUsers(){
		return ur.findAll();
	}
	

	public UsersEntity userLogin(String username, String pass) {
        UsersEntity loggedInUser = ur.findByUsername(username);
       
        if(loggedInUser.getPass().equals(pass)) {
            return loggedInUser;
        }else {
            return null;
        }
    } 
	
	
	 public UsersEntity register(UsersEntity user) {
			return ur.save(user);
	    }
    
	
	
	   public UsersEntity getByID(Integer userId) {
		   UsersEntity user = ur.getById(userId);
			System.out.println(user);
			return user;
	    }
	    
	    public UsersEntity getByUsername(String username) {
	    	UsersEntity user = ur.findByUsername(username);
			System.out.println(user);
			return user;
	    }

	    //lets the user update their information
		public String updateUser(UsersEntity user) {
			UsersEntity u = ur.findByUsername(user.getUsername());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setEmail(user.getEmail());
			u.setPass(user.getPass());
			u.setPhoneNumber(user.getPhoneNumber());
			u.setDob(user.getDob());
			ur.save(u);
			return u.toString();
		}
	

}
