package com.projectthree.springbanking.accounts.type;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CheckingTest {
	static Checking c, cc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Checking(34.9);
		cc = new Checking(4, 123.2);
	}

	@Test
	void test() {
		assertEquals(34.9, c.getBalance());
	}
	
	@Test
	void test1() {
		assertEquals(123.2, cc.getBalance());
	}
	
	@Test
	void test2() {
		assertNotNull(c.toString());
	
	}


}
