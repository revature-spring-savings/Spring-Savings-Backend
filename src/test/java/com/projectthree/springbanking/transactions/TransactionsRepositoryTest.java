package com.projectthree.springbanking.transactions;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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
