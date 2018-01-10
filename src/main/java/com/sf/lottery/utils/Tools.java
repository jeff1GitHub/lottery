package com.sf.lottery.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 工具类
 */
public class Tools {

	/**
	 * 计算MD5值
	 * @param str 需要计算的字符串
	 * @return MD5值
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String MD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes("utf-8"));
		BigInteger bigInt = new BigInteger(1, md.digest());
		return bigInt.toString(16);
	}

}
