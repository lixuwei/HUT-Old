package com.hut.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * MD5加密组件
 */
public class MD5 {
	public static final String KEY_MD5 = "MD5";
	/**
	 * MD5加密
	 */
	public static String toMD5(String data) {

		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance(KEY_MD5);	
			md5.update(data.getBytes());
			return new String(Hex.encodeHex(md5.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MD5.toMD5("简单加密"));
	}
}