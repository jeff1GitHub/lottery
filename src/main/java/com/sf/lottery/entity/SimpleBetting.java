package com.sf.lottery.entity;

import java.math.BigDecimal;

public class SimpleBetting {
	/** 日期 */
	private String date;
	/** 期号 */
	private String period;
	/** 投注金额 */
	private BigDecimal money;
	/** 结算金额 */
	private BigDecimal squareMoney;

	public String getDate() {
		return date;
	}

	public String getPeriod() {
		return period;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public BigDecimal getSquareMoney() {
		return squareMoney;
	}

}
