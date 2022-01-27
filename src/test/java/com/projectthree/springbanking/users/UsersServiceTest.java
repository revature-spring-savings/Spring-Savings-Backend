package com.projectthree.springbanking.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsService;

@RunWith(MockitoJUnitRunner.class)
class UsersServiceTest {

	@Mock
	UsersService us = org.mockito.Mockito.mock(UsersService.class);
	
	@Test
	public void getByAccountIDMockTest() {
		when(us.getAllTransactionsByAccountID(5)).thenReturn(Stream
				.of(new TransactionsEntity(), new TransactionsEntity()).collect(Collectors.toList()));
		assertEquals(2,  us.getAllTransactionsByAccountID(5).size());		
	}
	
	@Test
	public void getByAccountIDTest() {
		int i = us.getAllTransactionsByAccountID(1).size();
		List<TransactionsEntity> listT = us.getAllTransactionsByAccountID(1);
		assertEquals(i,  listT.size());		
	}
	

}
