package com.projectthree.springbanking.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class UsersServiceTest {

	@Mock
	UsersService us = org.mockito.Mockito.mock(UsersService.class);
	
	@Test
	public void getAllUsersMockTest() {
		when(us.getAllUsers()).thenReturn(Stream
				.of(new UsersEntity(), new UsersEntity()).collect(Collectors.toList()));
		assertEquals(2,  us.getAllUsers().size());		
	}
	
	@Test
	public void getByUserIDMockTest() {
		when(us.findByID(5)).thenReturn(new UsersEntity());
		assertNotNull(us.findByID(5));		
	}
	
	@Test
	public void getByUsernameMockTest() {
		when(us.getByUsername("jj@email.com")).thenReturn(new UsersEntity());
		assertNotNull(us.getByUsername("jj@email.com"));		
	}
	
	
	
//	@Test
//	public void getByAccountIDTest() {
//		int i = us.getAllTransactionsByAccountID(1).size();
//		List<TransactionsEntity> listT = us.getAllTransactionsByAccountID(1);
//		assertEquals(i,  listT.size());		
//	}
	

}
