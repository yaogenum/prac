package com.yaoge.cryption;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RsaCryptionTest {
	@Before
	public void setUp() throws Exception {
		
		System.out.println("start test");
		
	}

	@After
	public void tearDown() throws Exception {
		
		System.out.println("start test");
		
	}

	@Test
	public void test() {
		RsaCryption rsa;
		try {
			rsa = new RsaCryption();
			String message = "nihaocndihfdshxlfh12321" ;
			byte[] bytes = rsa.encryption(rsa.getPublickey(), message.getBytes()) ;
			System.out.println(new String(bytes));
			
			bytes =rsa.decryption(rsa.getPrivatekey() ,bytes );
			assertEquals("加密解密成功",message ,new String(bytes));
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
