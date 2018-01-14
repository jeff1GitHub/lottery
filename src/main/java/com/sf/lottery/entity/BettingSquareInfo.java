package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BettingSquareInfo {
	private long bettingId;
	private BigDecimal squareMoney;
	private Timestamp squareTime;

	public BettingSquareInfo(long bettingId, BigDecimal squareMoney, Timestamp squareTime) {
		this.bettingId = bettingId;
		this.squareMoney = squareMoney;
		this.squareTime = squareTime;
	}

	public long getBettingId() {
		return bettingId;
	}

	public BigDecimal getSquareMoney() {
		return squareMoney;
	}

	public Timestamp getSquareTime() {
		return squareTime;
	}

}
