package com.projectthree.springbanking.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.projectthree.springbanking.accounts.AccountsController;
import com.projectthree.springbanking.accounts.AccountsEntity;

class UsersControllerTest {

	@Mock
	UsersController ac = org.mockito.Mockito.mock(UsersController.class);
	
	static List<UsersEntity> l1 =  new ArrayList<UsersEntity>();
	static List<UsersEntity> l2 =  new ArrayList<UsersEntity>();
	static List<UsersEntity> l3 =  new ArrayList<UsersEntity>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		l1.add(new UsersEntity());
		
		l2.add(new UsersEntity());
		l2.add(new UsersEntity());
		
		l3.add(new UsersEntity());
		l3.add(new UsersEntity());
		l3.add(new UsersEntity());
	}


	@Test
	public void getByUserIDMockTest() {
		when(ac.retrieveAllUsers()).thenReturn(Stream
				.of(new UsersEntity(), new UsersEntity()).collect(Collectors.toList()));
		assertEquals(2,  ac.retrieveAllUsers().size());			
	}
	
//	@Test
//	public void getByUserITest() {
//		when(ac.createUser(l1)).thenReturn(Stream
//				.of(new UsersEntity()).collect(Collectors.toList()));
//		assertEquals(1,  ac.createUser(l1).size());			
//	}
}

