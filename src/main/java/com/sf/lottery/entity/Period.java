package com.sf.lottery.entity;

import java.util.Date;

/**
 * 彩票期号
 */
public class Period {
	/** 流水号 */
	private int id;
	/** 期号 */
	private String code;
	/** 彩票id */
	private int gameId;
	/** 开盘时间 */
	private Date startTime;
	/** 封盘时间 */
	private Date endTime;
	/** 开奖时间 */
	private Date finishTime;
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

	public int getGameId() {
		return gameId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Date getFinishTime() {
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
