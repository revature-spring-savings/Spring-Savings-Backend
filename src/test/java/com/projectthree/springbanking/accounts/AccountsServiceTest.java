package com.projectthree.springbanking.accounts;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class AccountsServiceTest {

	@Mock
	AccountsService as = org.mockito.Mockito.mock(AccountsService.class);
	
	AccountsEntity a = new AccountsEntity();
	
	@DisplayName("this is a display name")
	@Test
	public void getByAccountIDMockTest() {
		when(as.accountByID(5)).thenReturn(Optional.of(a));
		assertNotNull(as.accountByID(5));		
	}
	
	@Test
	public void getByAllAccountIDTest() {
		int i = as.allAccountsByID(1).size();
		List<AccountsEntity> listT = as.allAccountsByID(1);
		assertEquals(i,  listT.size());		
	}

}
