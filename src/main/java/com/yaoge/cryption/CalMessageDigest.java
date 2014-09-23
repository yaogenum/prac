package com.yaoge.cryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 单向加密，或计算摘要，主要是为了验证数据的完整性，不可逆
 * @author Administrator
 *
 */
public class CalMessageDigest {
	/**
	 * 计算摘要，可以使用高级封装类DigestUtils.md5DigestAsHex
	 * @param message
	 * @return
	 */
	public byte[] dealToDigest(String message) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5") ;
			digest.update(message.getBytes());
			return digest.digest() ;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null ;
	}

	public byte[] eccrypt(String info) throws NoSuchAlgorithmException{  
        //根据MD5算法生成MessageDigest对象  
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        byte[] srcBytes = info.getBytes();  
        //使用srcBytes更新摘要  
        md5.update(srcBytes);  
        //完成哈希计算，得到result  
        byte[] resultBytes = md5.digest();  
        return resultBytes;  
    }  
	
	
}	
