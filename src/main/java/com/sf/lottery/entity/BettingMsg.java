package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.util.Date;

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
	private Date bettingTime;
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
	private Date squareTime;

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPeriod() {
		return period;
	}

	public Date getBettingTime() {
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

	public Date getSquareTime() {
		return squareTime;
	}

}
