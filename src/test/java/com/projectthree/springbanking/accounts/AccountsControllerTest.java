package com.projectthree.springbanking.accounts;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AccountsControllerTest {


	@Mock
	AccountsController ac = org.mockito.Mockito.mock(AccountsController.class);
	
	static List<AccountsEntity> l1 =  new ArrayList<AccountsEntity>();
	static List<AccountsEntity> l2 =  new ArrayList<AccountsEntity>();
	static List<AccountsEntity> l3 =  new ArrayList<AccountsEntity>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		l1.add(new AccountsEntity());
		
		l2.add(new AccountsEntity());
		l2.add(new AccountsEntity());
		
		l3.add(new AccountsEntity());
		l3.add(new AccountsEntity());
		l3.add(new AccountsEntity());
	}


	@Test
	public void getByAccountIDMockTest() {
		when(ac.getAllAccounts()).thenReturn(Stream
				.of(new AccountsEntity(), new AccountsEntity()).collect(Collectors.toList()));
		assertEquals(2,  ac.getAllAccounts().size());			
	}
	
//	@Test
//	public void getByAccountITest() {
//		when(ac.CreateAccount(l1)).thenReturn(Stream
//				.of(new AccountsEntity()).collect(Collectors.toList()));
//		assertEquals(1,  ac.CreateAccount(l1).size());			
//	}

}

