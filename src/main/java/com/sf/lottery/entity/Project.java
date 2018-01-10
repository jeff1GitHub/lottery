package com.sf.lottery.entity;

import java.math.BigDecimal;

/**
 * 投注项
 */
public class Project {
	/** 项目编号 */
	private Integer id;
	/** 项目名称 */
	private String name;
	/** 彩票id */
	private Integer lotteryId;
	/** 赔率 */
	private BigDecimal odds;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}

	public BigDecimal getOdds() {
		return odds;
	}

}
