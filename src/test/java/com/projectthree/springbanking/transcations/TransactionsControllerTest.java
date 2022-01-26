package com.projectthree.springbanking.transcations;

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

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.transactions.TransactionsController;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsRepository;

class TransactionsControllerTest {
	
	@Mock
	TransactionsController tc = org.mockito.Mockito.mock(TransactionsController.class);
	
	static List<TransactionsEntity> l1 =  new ArrayList<TransactionsEntity>();
	static List<TransactionsEntity> l2 =  new ArrayList<TransactionsEntity>();
	static List<TransactionsEntity> l3 =  new ArrayList<TransactionsEntity>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		l1.add(new TransactionsEntity());
		
		l2.add(new TransactionsEntity());
		l2.add(new TransactionsEntity());
		
		l3.add(new TransactionsEntity());
		l3.add(new TransactionsEntity());
		l3.add(new TransactionsEntity());
	}


	@Test
	public void getByAccountIDMockTest() {
		when(tc.getAllTransactions()).thenReturn(Stream
				.of(new TransactionsEntity(), new TransactionsEntity()).collect(Collectors.toList()));
		assertEquals(2,  tc.getAllTransactions().size());			
	}
	
	@Test
	public void getByAccountITest() {
		when(tc.createNewTransaction(l1)).thenReturn(Stream
				.of(new AccountsEntity()).collect(Collectors.toList()));
		assertEquals(1,  tc.createNewTransaction(l1).size());			
	}

}
