package com.projectthree.springbanking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectthree.springbanking.users.UserRepository;
import com.projectthree.springbanking.users.UsersEntity;

@SpringBootTest
class SpringBankingApplicationTests {
	
	 UserRepository userRepo = Mockito.mock(UserRepository.class);
	
	
	@Test
	public void createUserTest() {
		//given
		UsersEntity user = new UsersEntity(1,"benjamin","bonnet",
				"bonbon@gmail.com","username","pass","404070","12/11/2020",
				"userrole"		
				);
		
		//when
	boolean exists = userRepo.findById(1);
	
	//Then 
	
	assertThat(exists).isNull();

	}
}
