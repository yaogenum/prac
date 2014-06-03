package com.yaoge.prac.prac;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


public class NiotestTest {

	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("test before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("test after");
	}

	@Test
	public void testNewio() {
		System.out.println("testing");
		assertEquals("exception",true,false);
	}

}
