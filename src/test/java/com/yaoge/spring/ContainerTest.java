package com.yaoge.spring;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContainerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Container con = new Container();
		assertEquals("ok result" , con.getInvokeResult("sss"),"ss");
	}

}
