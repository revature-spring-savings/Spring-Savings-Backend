package com.projectthree.springbanking.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
  
	@Autowired
	private UsersRepository ur;
	
	public List<UsersEntity> getAllUsers(){
		return ur.findAll();
	}
	
	public UsersEntity userLogin(UsersEntity user) {
		
		String username = user.getUsername();
		String pass = user.getPass();
        UsersEntity loggedInUser = ur.findByusername(username);
        System.out.println(loggedInUser);
        if(loggedInUser.getPass().equals(pass)) {
            return loggedInUser;
        }else {
            return null; 
        }
    } 
	
	 public UsersEntity register(UsersEntity user) {
		
			return ur.save(user);
	    }
    
	   public UsersEntity findByID(Integer userID) {
		   UsersEntity user = ur.findByuserID(userID);
		//	System.out.println(user);
			return user;
	    }
	    
	    public UsersEntity findByUsername(String username) {
	    	UsersEntity user = ur.findByusername(username);
			System.out.println(user);
			return user;
	    }

    // Do we need this method? (is it not the same as findByUsername)
    public UsersEntity getByUsername(String username) {
        UsersEntity user = ur.findByusername(username);
        System.out.println(user);
        return user;
    }

    //lets the user update their information
//    public String updateUser(UsersEntity user) {
//        UsersEntity u = ur.findByusername(user.getUsername());
//        u.setFirstName(user.getFirstName());
//        u.setLastName(user.getLastName());
//        u.setEmail(user.getEmail());
//        u.setPass(user.getPass());
//        u.setPhoneNumber(user.getPhoneNumber());
//        u.setDob(user.getDob());
//        ur.save(u);
//        return u.toString();
//    }

    public String updateUser(UsersEntity user) {
        System.out.println("TEST" + " " + user);
        UsersEntity u = ur.findByuserID(user.getUserID());
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
