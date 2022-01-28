package com.projectthree.springbanking.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectthree.springbanking.SpringBankingApplication;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsService;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
class TransactionsServiceTest {
	
	@Mock
	TransactionsService ts = org.mockito.Mockito.mock(TransactionsService.class);
	
	TransactionsEntity t = new TransactionsEntity();
	
	@DisplayName("this is a display name")
	@Test
	public void getByAccountIDMockTest() {
		when(ts.getAllTransactionsByAccountID(5)).thenReturn(Arrays.asList(t, t));
		assertEquals(2,  ts.getAllTransactionsByAccountID(5).size());		
	}
	
	@Test
	public void getByAccountIDTest() {
		int i = ts.getAllTransactionsByAccountID(1).size();
		List<TransactionsEntity> listT = ts.getAllTransactionsByAccountID(1);
		assertEquals(i,  listT.size());		
	}
	
	

}
