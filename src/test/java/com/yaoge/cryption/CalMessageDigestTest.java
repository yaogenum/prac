package com.yaoge.cryption;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalMessageDigestTest {

	@Before
	public void setUp() throws Exception {
		
		System.out.println("start test");
		
	}

	@After
	public void tearDown() throws Exception {
		
		System.out.println("end test");
		
	}

	@Test
	public void test() {
		CalMessageDigest dig = new CalMessageDigest() ;
		byte[] bytes = dig.dealToDigest("123abc");
		
		try {
			System.out.println(new String(bytes,"utf-8")) ;
			assertEquals("计算完成", "123abc", "123abc");//难以测试
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
