package com.projectthree.springbanking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.projectthree.springbanking.users.UserRepository;
import com.projectthree.springbanking.users.UsersEntity;
import com.projectthree.springbanking.users.UsersService;

@SpringBootTest
class SpringBankingApplicationTests {
	
	@MockBean
	private UserRepository userRepo;
	@Autowired
	private UsersService userService;
	
	@Test
	public void createUserTest() {
		//given
		UsersEntity user = new UsersEntity(1,"benjamin","bonnet",
				"bonbon@gmail.com","username","pass","404070","12/11/2020",
				"userrole"		
				);
		
		//when
	List<UsersEntity> exists = userRepo.findByEmail("bonbon@gmail.com");
	
	//Then 
	
	assertThat(exists).isNull();

	}
}
