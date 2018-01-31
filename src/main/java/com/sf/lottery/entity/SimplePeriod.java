package com.sf.lottery.entity;

/**
 * 简单彩票期号
 */
public class SimplePeriod {
	/** 日期 */
	private String date;
	/** 期号 */
	private String code;
	/** 开奖结果 */
	private String result;

	public String getCode() {
		return code;
	}

	public String getDate() {
		return date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
