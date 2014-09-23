package com.yaoge.cryption;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA双向加密
 * @author Administrator
 *
 */
public class RsaCryption {
	/**
	 * 处理的byte
	 */
	private byte[] bytes;
	/**
	 * 具体处理工厂模式下具体算法提供
	 */
	private Cipher cipher ;
	/**
	 * key对的生成器
	 */
	private KeyPairGenerator pair ;
	/**
	 * key对
	 */
	private KeyPair keys ;
	
	/**
	 * 公钥，这里测试，使用时不能暴露
	 */
	private PublicKey publickey;
	/**
	 * 私钥，这里测试，使用时不能暴露
	 */
	private PrivateKey privatekey;
	
	
	public PublicKey getPublickey() {
		return publickey;
	}

	public void setPublickey(PublicKey publickey) {
		this.publickey = publickey;
	}

	public PrivateKey getPrivatekey() {
		return privatekey;
	}

	public void setPrivatekey(PrivateKey privatekey) {
		this.privatekey = privatekey;
	}
	/**
	 * 完成准备工作，获取RSA算法key对，生成private,public 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	RsaCryption() throws NoSuchAlgorithmException, NoSuchPaddingException {
		pair = KeyPairGenerator.getInstance("RSA") ;
		cipher = Cipher.getInstance("RSA") ;
		
		keys = pair.generateKeyPair() ;
		
		publickey = (RSAPublicKey)keys.getPublic() ;
		privatekey = (RSAPrivateKey)keys.getPrivate() ;
		
	}
	
	/**
	 * 加密
	 * @param publicKey
	 * @param dealToEncryption
	 * @return
	 */
	public byte[]  encryption(PublicKey publicKey , byte[] dealToEncryption) {
		
		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey) ;
			return cipher.doFinal(dealToEncryption) ;
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
		
		
	}
	
	/**
	 * 解密
	 * @param privatekey
	 * @param dealToDecryption
	 * @return
	 */
	public byte[] decryption(PrivateKey privatekey ,byte[] dealToDecryption) {
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, privatekey);
			
				return cipher.doFinal(dealToDecryption) ;
				// TODO Auto-generated catch block
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null ;
		
	}
		
}










