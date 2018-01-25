package com.sf.lottery.entity;

import java.math.BigDecimal;

/**
 * 注单统计
 */
public class BettingStatistics {
	/** 彩票编号 */
	private int lotteryId;
	/** 投注项 */
	private int project;
	/** 投注项数量 */
	private int projectCount;
	/** 投注项金额 */
	private BigDecimal moneySum;

	public int getLotteryId() {
		return lotteryId;
	}

	public int getProject() {
		return project;
	}

	public int getProjectCount() {
		return projectCount;
	}

	public BigDecimal getMoneySum() {
		return moneySum;
	}

}
