package com.projectthree.springbanking.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class UsersRepositoryTest {

	@Mock
	UsersRepository ar = org.mockito.Mockito.mock(UsersRepository.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void getByUserIDMockTest() {
		when(ar.findByuserID(5)).thenReturn(new UsersEntity());
		assertNotNull(ar.findByuserID(5));		
	}
	
	@Test
	public void getByUsernameMockTest() {
		when(ar.findByusername("jj@email.com")).thenReturn(new UsersEntity());
		assertNotNull(ar.findByusername("jj@email.com"));		
	}
	
	@Test
	public void getByUseremailMockTest() {
		when(ar.findByEmail("JJ")).thenReturn(new UsersEntity());
		assertNotNull(ar.findByEmail("JJ"));		
	}
}
