package com.projectthree.springbanking.accounts;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class AccountsRepositoryTest {
	
	@Mock
	AccountsRepository ar = org.mockito.Mockito.mock(AccountsRepository.class);
	
	AccountsEntity a = new AccountsEntity();

	@Test
	public void findAllTest() {		
		when(ar.findAll()).thenReturn(Arrays.asList(a));
		assertNotNull(ar.findAll());			
	}
	
	@Test
	public void findByIDTest() {		
		when(ar.findById(5)).thenReturn(Optional.of(a));
		assertNotNull(ar.findById(5));	
	}
	
	@Test
	public void findByUserIDTest() {		
		when(ar.findByuserID(5)).thenReturn(Arrays.asList(a));
		assertNotNull(ar.findByuserID(5));	
	}
	
	@Test
	public void findByAccountIDTest() {		
		when(ar.findByAccountID(5)).thenReturn(Optional.of(a));
		assertNotNull(ar.findByAccountID(5));	
	}
	
	
}
