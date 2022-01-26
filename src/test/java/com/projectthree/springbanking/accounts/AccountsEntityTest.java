package com.projectthree.springbanking.accounts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;

class AccountsEntityTest {

	static AccountsEntity t, u, v;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new AccountsEntity();
		u = new AccountsEntity();
		v = new AccountsEntity();	
	}

//	@Test
//	void equalsTest() {
//		assertEquals(t, u);
//		assertEquals(t.hashCode(), u.hashCode());
//	}
	
	@Test
	public void testAccountID() {
		t.setAccountID(5);
		assertEquals(t.getAccountID(), 5);
	}
	
//	@Test
//	public void testTransactionEntity() {
//		t.setTransactionEntity(new TransactionsEntity());
//		assertEquals(t.getTransactionEntity(), new TransactionsEntity());
//	}
	
//	@Test
//	public void testAmount() {
//		t.setAmount(5.78);
//		assertEquals(t.getAmount(), 5.78);
//	}
	
//	@Test
//	public void testDate() {
//		t.setTransactionDate("my birthday");
//		assertEquals(t.getTransactionDate(), "my birthday");
//	}
	
	@Test
	public void testTID() {
		t.setAccountID(8);
		assertEquals(t.getAccountID(), 8);
	}
	
	@Test
	public void testType() {
		t.setAccountType("CHECKING");
		assertEquals(t.getAccountType(), "CHECKING");
	}
	
//	@Test
//	public void testNote() {
//		t.setTransactionNote("payday");
//		assertEquals(t.getTransactionNote(), "payday");
//	}
	
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
	    final Class<AccountsEntity> classUnderTest = AccountsEntity.class;
	  assertNotNull(classUnderTest);
	}
	

}
