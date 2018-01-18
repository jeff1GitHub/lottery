package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 注单
 */
public class Betting {
	/** 注单流水号 */
	private long id;
	/** 帐号编号 */
	private long userId;
	/** 期号 */
	private String period;
	/** 投注时间 */
	private Date bettingTime;
	/** 彩票id */
	private int lotteryId;
	/** 投注项 */
	private int project;
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
	/** 是否派彩 */
	private int prize;
	/** 派奖时间 */
	private Date prizeTime;
	
	public Betting() {}

	public Betting(long id, long userId, String period, Date bettingTime, int lotteryId, int project, BigDecimal odds, BigDecimal money) {
		this.id = id;
		this.userId = id;
		this.period = period;
		this.bettingTime = bettingTime;
		this.lotteryId = lotteryId;
		this.project = project;
		this.odds = odds;
		this.money = money;
	}

	public long getId() {
		return id;
	}
	
	public long getUserId() {
		return userId;
	}

	public String getPeriod() {
		return period;
	}

	public Date getBettingTime() {
		return bettingTime;
	}

	public int getLotteryId() {
		return lotteryId;
	}

	public int getProject() {
		return project;
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

	public int getPrize() {
		return prize;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

}
