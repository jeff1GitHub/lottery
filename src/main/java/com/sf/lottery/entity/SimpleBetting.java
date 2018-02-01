package com.sf.lottery.entity;

import java.math.BigDecimal;

public class SimpleBetting {
	/** 下注时间 */
	private String bettingTime;
	/** 期号 */
	private String period;
	/** 投注内容 */
	private String content;
	/** 投注金额 */
	private BigDecimal money;
	/** 结算金额 */
	private BigDecimal squareMoney;

	public String getBettingTime() {
		return bettingTime;
	}

	public String getPeriod() {
		return period;
	}

	public String getContent() {
		return content;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public BigDecimal getSquareMoney() {
		return squareMoney;
	}

}
