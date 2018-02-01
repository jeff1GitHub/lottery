package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 注单
 */
public class Betting {
	/** 注单流水号 */
	private long id;
	/** 帐号编号 */
	private long userId;
	/** 账号名称 */
	private String userName;
	/** 期号 */
	private String period;
	/** 投注时间 */
	private LocalDateTime bettingTime;
	/** 彩票编号 */
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
	private LocalDateTime squareTime;
	/** 是否派彩 */
	private int prize;
	/** 派奖时间 */
	private LocalDateTime prizeTime;
	
	public Betting() {}

	public Betting(long id, long userId, String userName, String period, LocalDateTime bettingTime, int lotteryId, int project, BigDecimal odds, BigDecimal money) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public String getPeriod() {
		return period;
	}

	public LocalDateTime getBettingTime() {
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

	public LocalDateTime getSquareTime() {
		return squareTime;
	}

	public int getPrize() {
		return prize;
	}

	public LocalDateTime getPrizeTime() {
		return prizeTime;
	}

}
