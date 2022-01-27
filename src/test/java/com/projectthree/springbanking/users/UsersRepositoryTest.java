package com.projectthree.springbanking.users;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
import com.projectthree.springbanking.transactions.TransactionsRepository;

@RunWith(MockitoJUnitRunner.class)
class UsersRepositoryTest {

	@Mock
	UsersRepository ar = org.mockito.Mockito.mock(UsersRepository.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	public void getByAccountIDMockTest() {
//		when(ar.findAllByAccountID(5)).thenReturn(Stream
//				.of(new TransactionsEntity(), new TransactionsEntity()).collect(Collectors.toList()));
//		assertEquals(2,  ar.findAllByAccountID(5).size());			
//	}
	
	@Test
	public void getByUserIDMockTest() {
		when(ar.findByuserID(5)).thenReturn(new UsersEntity());
		assertNotNull(ar.findByuserID(5));		
	}
}
