package com.yaoge.cryption;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DesEncryptionTest {

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
		
		try {
			DesEncryption des =  new DesEncryption();
			String s = "abc123x23we23" ;
			
			byte[] deal = des.dealinput(s) ;
			
			deal = des.decryption(deal);
			
			assertEquals("加密解密成功", s, new String(deal));

			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
