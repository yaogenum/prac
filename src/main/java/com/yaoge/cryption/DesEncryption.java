package com.yaoge.cryption;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.omg.PortableServer.THREAD_POLICY_ID;
/**
 * 使用DES算法进行加密演示，
 * 双向加密 非对称算法DES（双向加密与单向加密（无明文，一般为计算摘要，验证信息，而不是用于安全传输信息），双向加密下非对称算法为公钥与密钥不一样）
 * 
 * 
 * @author Administrator
 *
 */
public class DesEncryption {

	private KeyGenerator generator ;
	
	private SecretKey key ;
	
	private Cipher cipher ;
	
	private byte[] bytes ;
	
	
	
	DesEncryption() throws NoSuchAlgorithmException, NoSuchPaddingException {
		
		Security.addProvider(new com.sun.crypto.provider.SunJCE()) ;
		
		generator = KeyGenerator.getInstance("DES") ;
		key = generator.generateKey() ;
		cipher = Cipher.getInstance("DES") ;
		
	}
	
	
	public byte[] dealinput(String dealEncryptionString) {
		
		
		return encryption(dealEncryptionString.getBytes()) ;
	}
	
	public byte[] dealoutput(String dealDecryptionString) throws UnsupportedEncodingException {
		
		byte[] deal = dealDecryptionString.getBytes("UTF-8") ;
		
		return decryption(deal);
	}
	
	public byte[] encryption(byte[] dealEncryptionBytes) {
		
		try {
			cipher.init(Cipher.ENCRYPT_MODE,key ) ;
			
			try {
				bytes = cipher.doFinal(dealEncryptionBytes) ;
				
				return bytes;
				
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("encryption ok") ;
		return null ;
		
	}
	
	public byte[] decryption(byte[] dealDecryptionBytes) {
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			
			try {
				bytes = cipher.doFinal(dealDecryptionBytes) ;
				return bytes;
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("decryption ok") ;
		return null ;
		
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException {
		try {
			DesEncryption des =  new DesEncryption();
			String s = "abc123x23we23" ;
			
			byte[] deal = des.dealinput(s) ;
			
			deal = des.decryption(deal);

			
			System.out.println(new String(deal));
			
			System.out.println(System.getProperty("file.encoding")+";"+Charset.defaultCharset());

			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}








