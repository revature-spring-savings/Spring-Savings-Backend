package com.projectthree.springbanking.transcations;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.transactions.TransactionsRepository;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
class TransactionsRepositoryTest {
	
	@Mock
	TransactionsRepository tr = org.mockito.Mockito.mock(TransactionsRepository.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void getByAccountIDMockTest() {
		when(tr.findAllByAccountID(5)).thenReturn(Stream
				.of(new TransactionsEntity(), new TransactionsEntity()).collect(Collectors.toList()));
		assertEquals(2,  tr.findAllByAccountID(5).size());			
	}
	
	@Test
	public void getByUserIDMockTest() {
		when(tr.findByUserID(5)).thenReturn(Stream
				.of(new TransactionsEntity(), new TransactionsEntity()).collect(Collectors.toList()));
		assertEquals(2,  tr.findByUserID(5).size());		
	}
}
