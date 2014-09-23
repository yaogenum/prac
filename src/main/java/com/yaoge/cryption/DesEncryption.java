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
	/**
	 * 钥匙生成器
	 */
	private KeyGenerator generator ;
	/**
	 * 钥匙
	 */
	private SecretKey key ;
	/**
	 * 具体处理工厂模式下具体算法提供
	 */
	private Cipher cipher ;
	/**
	 * 返回处理后的数字，二进制
	 */
	private byte[] bytes ;
	
	/**
	 * 完成对cipher,钥匙等的准备工作
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	
	DesEncryption() throws NoSuchAlgorithmException, NoSuchPaddingException {
		
		Security.addProvider(new com.sun.crypto.provider.SunJCE()) ;
		
		generator = KeyGenerator.getInstance("DES") ;
		key = generator.generateKey() ;
		cipher = Cipher.getInstance("DES") ;
		
	}
	
	
	public byte[] dealinput(String dealEncryptionString) {
		
		
		return encryption(dealEncryptionString.getBytes()) ;
	}
	/**
	 * 此处不可用，问题：将加密后的bytes转换成string,再转换成byte时，与加密后的bytes是不一样的，其中主要是string获取bytes时受平台字符集影响，bytes数组从内容和长度不一致
	 * 所以警告使用bytes不要进行改写
	 * @param dealDecryptionString
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public byte[] dealoutput(String dealDecryptionString) throws UnsupportedEncodingException {
		
		byte[] deal = dealDecryptionString.getBytes("UTF-8") ;
		
		return decryption(deal);
	}
	/**
	 * 加密
	 * @param dealEncryptionBytes
	 * @return
	 */
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
	/**
	 * 解密
	 * @param dealDecryptionBytes
	 * @return
	 */
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
	
	
}








