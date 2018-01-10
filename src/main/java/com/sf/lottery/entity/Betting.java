package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 注单
 */
public class Betting {
	/** 注单流水号 */
	private Long id;
	/** 期号 */
	private String period;
	/** 投注时间 */
	private Date bettingTime;
	/** 彩票id */
	private Integer lotteryId;
	/** 投注项 */
	private Integer project;
	/** 赔率 */
	private BigDecimal odds;
	/** 投注金额 */
	private BigDecimal money;
	/** 是否结算 */
	private Integer square;
	/** 结算时间 */
	private Date squareTime;
	/** 是否派彩 */
	private Integer prize;
	/** 派奖时间 */
	private Date prizeTime;

	public Long getId() {
		return id;
	}

	public String getPeriod() {
		return period;
	}

	public Date getBettingTime() {
		return bettingTime;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}

	public Integer getProject() {
		return project;
	}

	public BigDecimal getOdds() {
		return odds;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public Integer getSquare() {
		return square;
	}

	public Date getSquareTime() {
		return squareTime;
	}

	public Integer getPrize() {
		return prize;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

}
