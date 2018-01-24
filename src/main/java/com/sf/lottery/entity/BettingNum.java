package com.sf.lottery.entity;

/**
 * 不同状态注单数量
 */
public class BettingNum {
	/** 注单数量 */
	private int betNum;
	/** 已结算注单数量 */
	private int squaredNum;
	/** 未结算注单数量 */
	private int unsquareNum;
	/** 其它状态注单数量 */
	private int otherBetNum;

	public int getBetNum() {
		return betNum;
	}

	public int getSquaredNum() {
		return squaredNum;
	}

	public int getUnsquareNum() {
		return unsquareNum;
	}

	public int getOtherBetNum() {
		return otherBetNum;
	}

}
