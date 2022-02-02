package com.projectthree.springbanking.transactions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.users.UsersEntity;

class TransactionsEntityTest {
	static TransactionsEntity t, u, v;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new TransactionsEntity();
		u = t;
		v = new TransactionsEntity();	
	}

	@Test
	void equalsTest() {
		assertEquals(t, u);
		assertEquals(t.hashCode(), u.hashCode());
	}
	
	@Test
	public void testAccountID() {
		t.setAccountID(5);
		assertEquals(t.getAccountID(), 5);
	}
	
	@Test
	public void testAccountsEntity() {
		t.setAccountsEntity(new AccountsEntity());
		assertEquals(t.getAccountsEntity(), new AccountsEntity());
	}
	
	@Test
	public void testAmount() {
		t.setAmount(5.78);
		assertEquals(t.getAmount(), 5.78);
	}
	
	@Test
	public void testDate() {
		t.setTransactionDate("my birthday");
		assertEquals(t.getTransactionDate(), "my birthday");
	}
	
	@Test
	public void testTID() {
		t.setTransactionID(8);
		assertEquals(t.getTransactionID(), 8);
	}
	
	@Test
	public void testType() {
		t.setTransactionType("withdraw");
		assertEquals(t.getTransactionType(), "withdraw");
	}
	
	@Test
	public void testNote() {
		t.setTransactionNote("payday");
		assertEquals(t.getTransactionNote(), "payday");
	}
	
	@Test
	public void testUID() {
		t.setUserID(7);
		assertEquals(t.getUserID(), 7);
	}
	
	@Test
	public void testUser() {
		t.setUsersEntity(new UsersEntity());
		assertEquals(t.getUsersEntity(), new UsersEntity());
	}
	
	@Test
	public void toStringTest() {
		assertNotNull(t.toString());
	}	

	@Test
	public void Should_Pass_All_Pojo_Tests() {
	    final Class<TransactionsEntity> classUnderTest = TransactionsEntity.class;
	  assertNotNull(classUnderTest);
	}
	
	
	
	
	

}
