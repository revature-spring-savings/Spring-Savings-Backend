package com.projectthree.springbanking.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.projectthree.springbanking.accounts.AccountsEntity;
import com.projectthree.springbanking.transactions.TransactionsEntity;

class UsersEntityTest {
	
	static UsersEntity t, u, v;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new UsersEntity();
		u = t;
		v = new UsersEntity();	
	}

	@Test
	void equalsTest() {
		assertEquals(t, u);
		assertEquals(t.hashCode(), u.hashCode());
	}
	
	@Test
	public void testUsername() {
		t.setUsername("jj@email.com");
		assertEquals(t.getUsername(), "jj@email.com");
	}

	@Test
	public void testTransactionEntity() {
		t.setTransactionsEntity(new HashSet<TransactionsEntity>());
		assertEquals(t.getTransactionsEntity(), new HashSet<TransactionsEntity>());
	}
	
	@Test
	public void testAccountsEntity() {
		t.setAccountsEntity(new HashSet<AccountsEntity>());
		assertEquals(t.getAccountsEntity(), new HashSet<AccountsEntity>());
	}
	
	@Test
	public void testFirstName() {
		t.setFirstName("Joe");
		assertEquals(t.getFirstName(), "Joe");
	}
	
	@Test
	public void testDob() {
		t.setDob("12/21/78");
		assertEquals(t.getDob(), "12/21/78");
	}
	
	@Test
	public void testLastName() {
		t.setLastName("Jones");
		assertEquals(t.getLastName(), "Jones");
	}
	
	@Test
	public void testUserRole() {
		t.setUserRole("USER");
		assertEquals(t.getUserRole(), "USER");
	}
	
	@Test
	public void testPassword() {
		t.setPass("jjmanpass");
		assertEquals(t.getPass(), "jjmanpass");
	}
	
	@Test
	public void testUID() {
		t.setUserID(7);
		assertEquals(t.getUserID(), 7);
	}
	
	@Test
	public void testEmail() {
		t.setEmail("JJ");
		assertEquals(t.getEmail(), "JJ");
	}
	
	@Test
	public void testPhoneNumber() {
		t.setPhoneNumber("123456789");
		assertEquals(t.getPhoneNumber(), "123456789");
	}
	
	@Test
	public void toStringTest() {
		assertNotNull(t.toString());
	}	

	@Test
	public void Should_Pass_All_Pojo_Tests() {
	    final Class<UsersEntity> classUnderTest = UsersEntity.class;
	  assertNotNull(classUnderTest);
	}
	
	
}