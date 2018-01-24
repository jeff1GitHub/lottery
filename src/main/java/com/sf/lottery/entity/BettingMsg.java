package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 注单信息
 */
public class BettingMsg {
	/** 注单流水号 */
	private long id;
	/** 账号名称 */
	private String userName;
	/** 期号 */
	private String period;
	/** 投注时间 */
	private LocalDateTime bettingTime;
	/** 彩票名称 */
	private String lotteryName;
	/** 投注项名称 */
	private String projectName;
	/** 赔率 */
	private BigDecimal odds;
	/** 投注金额 */
	private BigDecimal money;
	/** 是否结算 */
	private int square;
	/** 结算金额 */
	private BigDecimal squareMoney;
	/** 结算时间 */
	private LocalDateTime squareTime;

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPeriod() {
		return period;
	}

	public LocalDateTime getBettingTime() {
		return bettingTime;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public String getProjectName() {
		return projectName;
	}

	public BigDecimal getOdds() {
		return odds;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public int getSquare() {
		return square;
	}

	public BigDecimal getSquareMoney() {
		return squareMoney;
	}

	public LocalDateTime getSquareTime() {
		return squareTime;
	}

}
