package com.mo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * MD5加密
 * @author CMY
 *
 */

public class Encrypt {
	
	public static final String  MD5 = "md5";
	
	public static String encrypt(String str){
		try {
			MessageDigest md = MessageDigest.getInstance(MD5);
			byte[] bytes = md.digest(str.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(bytes);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
