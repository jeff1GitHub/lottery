package com.sf.lottery.entity;

/**
 * 彩票信息
 */
public class Lottery {
	/** 流水号 */
	private Integer id;
	/** 彩票名称 */
	private String name;
	/** 彩票类型 */
	private Integer type;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getType() {
		return type;
	}

}
