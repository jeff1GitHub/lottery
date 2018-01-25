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
	/** 盈利 */
	private BigDecimal profit;
	/** 亏损 */
	private BigDecimal loss;

	public BettingSquareSummary() {}
	
	public BettingSquareSummary(String userName, BigDecimal betMoney, BigDecimal profit, BigDecimal loss) {
		this.userName = userName;
		this.betMoney = betMoney;
		this.profit = profit;
		this.loss = loss;
	}

	public String getUserName() {
		return userName;
	}

	public BigDecimal getBetMoney() {
		return betMoney;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public BigDecimal getLoss() {
		return loss;
	}

}
