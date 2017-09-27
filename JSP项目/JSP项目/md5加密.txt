package com.qq.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncryptUtil {
	
	public static final String MD5 = "md5";
	
	/**
	 * 加密的过程通常是根据某种加密算法把明文改变成密文
	 * 
	 * 不可逆的加密算法   ----》     只能由明文得到密文，不可能从密文解密到明文       MD5加密算法
	 * 可逆的加密算法       ----》    不仅仅可以由明文得到密文，也可以由密文解密成密文      SHA加密算法
	 * 
	 * JDK提供了加密方法：
	 * MD5加密算法   
	 * SHA加密算法
	 * 
	 * MD5与SHA都是基于消息摘要算法的加密算法
	 * 
	 * java.security包    java的安全框架
	 * 
	 */
	
	public static String encrypt(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance(MD5); // 消息摘要类
			byte[] bytes = digest.digest(str.getBytes()); // 对字符串明文进行加密，字节数组。返回加密好的字节数组(乱码)
			BASE64Encoder encoder = new BASE64Encoder(); // 基于Base64字符编码的类，可以把乱码转化成可读性较好的字符串
			return encoder.encode(bytes); // 把md5加密后所产生的乱码的字节数组转化成字符串
		} catch (NoSuchAlgorithmException e) { // 未找到的加密算法异常
			e.printStackTrace();
		} 
		return null;
	}
}
