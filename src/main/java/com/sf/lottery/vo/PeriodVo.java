package com.sf.lottery.vo;

import com.sf.lottery.entity.Period;

/**
 * 彩票期号
 */
public class PeriodVo {
	/** 流水号 */
	private int id;
	/** 期号 */
	private String code;
	/** 彩票id */
	private int gameId;
	/** 剩余封盘时间 */
	private int endTime;
	/** 剩余开奖时间 */
	private int finishTime;
	/** 开奖结果 */
	private String result;
	/** 状态 */
	private int status;
	
	public PeriodVo(Period period) {
		this.id = period.getId();
		this.code = period.getCode();
		this.gameId = period.getGameId();
		this.status = period.getStatus();
		if(this.status == 1){
			this.result = period.getResult();
		}
		if(this.status == 0){
			long nowTime = System.currentTimeMillis();
			this.endTime = (int)Math.ceil((period.getEndTime().getTime() - nowTime) / 1000.0);
			this.finishTime = (int)Math.ceil((period.getFinishTime().getTime() - nowTime) / 1000.0);
		}
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public int getGameId() {
		return gameId;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getFinishTime() {
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
