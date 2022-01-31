package com.projectthree.springbanking.transactions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.projectthree.springbanking.accounts.AccountsEntity;


@AutoConfigureMockMvc
class TransactionsControllerTest {
	
	@Mock
	TransactionsController tc = org.mockito.Mockito.mock(TransactionsController.class);
	
	TransactionsController tcReal = new TransactionsController();
	
	@MockBean
	private MockMvc mockmvc;
	
	@Mock
	TransactionsRepository tr = org.mockito.Mockito.mock(TransactionsRepository.class);
	
	static List<TransactionsEntity> l1 =  new ArrayList<TransactionsEntity>();
	static List<TransactionsEntity> l2 =  new ArrayList<TransactionsEntity>();
	static List<TransactionsEntity> l3 =  new ArrayList<TransactionsEntity>();
	static ResultActions l4;
	
	static TransactionsEntity t = new TransactionsEntity();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		l1.add(new TransactionsEntity());
		
		l2.add(new TransactionsEntity());
		l2.add(new TransactionsEntity());
		
		l3.add(new TransactionsEntity());
		l3.add(new TransactionsEntity());
		l3.add(new TransactionsEntity());
	}
	
	@BeforeEach
    public void setUp(){
        t.setTransactionDate("1");
        t.setTransactionID(1);
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
	
	@Test
	public void fetchAllTransk() throws Exception {
		when(tc.getAllTransactions()).thenReturn(l3);
//		mockmvc.perform(get("/transactions"))
//			.andExpect(status().isOk())
//			.andExpect(content().contentType("application/json;charset=UTF-8"))
//			.andReturn();
	}

	@Test
	public void fetchByID() {
		t.setTransactionID(1);
		when(tr.findById(1)).thenReturn(Optional.of(t));
		
		TransactionsEntity tt= tr.findById(1).get();
		assertEquals(tt.getTransactionID(), 1);
	}
	
	
	@Test
	public void stuff() {
		when(tr.findAll()).thenReturn(l3);
	//	verify(tr, times(1).findAll());
	}
	
	@Test
	void hello() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/transactions/");
	}

	

}
