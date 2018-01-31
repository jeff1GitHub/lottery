package com.sf.lottery.entity;

import java.math.BigDecimal;

/**
 * 注单结算汇总
 */
public class BettingSquareSummary {
	/** 帐号 */
	private String userName;
	/** 下注金额 */
	private BigDecimal betMoney;
	/** 亏损 */
	private BigDecimal loss;
	/** 盈利 */
	private BigDecimal profit;

	public BettingSquareSummary() {}
	
	public BettingSquareSummary(String userName, BigDecimal betMoney, BigDecimal loss) {
		this.userName = userName;
		this.betMoney = betMoney;
		this.loss = loss;
	}

	public String getUserName() {
		return userName;
	}

	public BigDecimal getBetMoney() {
		return betMoney;
	}
	
	public BigDecimal getLoss() {
		return loss;
	}

	public void computeProfit() {
		this.profit = betMoney.add(loss);
	}

	public BigDecimal getProfit() {
		return profit;
	}
	
}
