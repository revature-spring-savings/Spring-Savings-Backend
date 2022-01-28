package com.projectthree.springbanking.transactions;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsRepository;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
class TransactionsRepositoryTest {
	
	@Mock
	TransactionsRepository tr = org.mockito.Mockito.mock(TransactionsRepository.class);
	
	TransactionsEntity t = new TransactionsEntity();

	@Test
	public void getByAccountIDMockTest() {
		when(tr.findAllByAccountID(5)).thenReturn(Arrays.asList(t, t));
		assertEquals(2,  tr.findAllByAccountID(5).size());			
	}
	
	@Test
	public void getByUserIDMockTest() {
		when(tr.findByUserID(5)).thenReturn(Arrays.asList(t, t));
		assertEquals(2,  tr.findByUserID(5).size());		
	}
	
}
