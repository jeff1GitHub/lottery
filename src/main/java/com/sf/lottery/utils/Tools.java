package com.sf.lottery.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

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
	
	/**
	 * 获取随机数字符串，并用“,”分割
	 * @param amount 产生随机数的数量
	 * @param maxNum 随机随机数范围:0(包含)~maxNum(不包含)
	 * @return 随机数字符串
	 */
	public static String getRandomNum(int amount, int maxNum) {
		StringBuilder randomStr = new StringBuilder();
		while(--amount >= 0){
			randomStr.append(ThreadLocalRandom.current().nextInt(maxNum));
			if(amount > 0){
				randomStr.append(",");
			}
		}
		return randomStr.toString();
	}

}
