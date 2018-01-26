package com.sf.lottery.entity;

import java.time.LocalDateTime;

/**
 * 彩票期号
 */
public class Period {
	/** 流水号 */
	private int id;
	/** 期号 */
	private String code;
	/** 日期 */
	private String date;
	/** 彩票编号 */
	private int gameId;
	/** 开盘时间 */
	private LocalDateTime startTime;
	/** 封盘时间 */
	private LocalDateTime endTime;
	/** 开奖时间 */
	private LocalDateTime finishTime;
	/** 开奖结果 */
	private String result;
	/** 状态 */
	private int status;

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getDate() {
		return date;
	}

	public int getGameId() {
		return gameId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
