package com.projectthree.springbanking.accounts.type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SavingsTest {
	Savings s = new Savings(4);
	Savings ss = new Savings(2,4.5);

	@Test
	void test() {
		assertEquals(s.getBalance(), 4);
	}
	
	@Test
	void test2() {
		assertEquals(ss.getBalance(), 4.5);
	}
	
	@Test
	void test3() {
		assertNotNull(ss.toString());
	}

}
