package com.sf.lottery.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	 * 获取随机数数组
	 * @param amount 产生随机数的数量
	 * @param maxNum 随机随机数范围:0(包含)~maxNum(不包含)
	 * @return 随机数字数组
	 */
	public static int[] getRandomNum(int amount, int maxNum) {
		int[] randomArr = new int[amount];
		while(--amount >= 0){
			randomArr[amount] = ThreadLocalRandom.current().nextInt(maxNum);
		}
		return randomArr;
	}
	
	/**
	 * 将Java对象转成Json字符串
	 * @param obj java对象
	 * @return json字符串
	 * @throws Exception
	 */
	public static String getJsonString(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper(); 
		String json = mapper.writeValueAsString(obj);
		return json;
	}

}
