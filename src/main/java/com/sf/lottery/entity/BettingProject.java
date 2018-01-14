package com.sf.lottery.entity;

/**
 * 注单投注项
 */
public class BettingProject {
	/** 彩票id */
	private int lotteryId;
	/** 期号 */
	private String period;
	/** 投注项 */
	private int project;
	/** 投注量 */
	private int count;

	public int getLotteryId() {
		return lotteryId;
	}

	public String getPeriod() {
		return period;
	}

	public int getProject() {
		return project;
	}

	public int getCount() {
		return count;
	}

}
