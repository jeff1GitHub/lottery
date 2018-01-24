package com.sf.lottery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BettingSquareInfo {
	private long bettingId;
	private BigDecimal squareMoney;
	private LocalDateTime squareTime;

	public BettingSquareInfo(long bettingId, BigDecimal squareMoney, LocalDateTime squareTime) {
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

	public LocalDateTime getSquareTime() {
		return squareTime;
	}

}
