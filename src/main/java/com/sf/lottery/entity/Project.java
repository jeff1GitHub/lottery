package com.sf.lottery.entity;

import java.math.BigDecimal;

/**
 * 投注项
 */
public class Project {
	/** 项目编号 */
	private int id;
	/** 项目名称 */
	private String name;
	/** 彩票id */
	private int lotteryId;
	/** 赔率 */
	private BigDecimal odds;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLotteryId() {
		return lotteryId;
	}

	public BigDecimal getOdds() {
		return odds;
	}

}
