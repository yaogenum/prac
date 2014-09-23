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

public class RsaCryption {
	
	private byte[] bytes;
	
	private Cipher cipher ;
	
	private KeyPairGenerator pair ;
	
	private KeyPair keys ;
	
	private PublicKey publickey;
	
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

	RsaCryption() throws NoSuchAlgorithmException, NoSuchPaddingException {
		pair = KeyPairGenerator.getInstance("RSA") ;
		cipher = Cipher.getInstance("RSA") ;
		
		keys = pair.generateKeyPair() ;
		
		publickey = (RSAPublicKey)keys.getPublic() ;
		privatekey = (RSAPrivateKey)keys.getPrivate() ;
		
	}
	
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
	
	
	public static void main (String args[] ) {
		try {
			RsaCryption rsa =new RsaCryption() ;
			String message = "nihaocndihfdshxlfh12321" ;
			byte[] bytes = rsa.encryption(rsa.getPublickey(), message.getBytes()) ;
			System.out.println(new String(bytes));
			
			bytes =rsa.decryption(rsa.getPrivatekey() ,bytes );
			System.out.println(new String(bytes));
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}










