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
	private long endTime;
	/** 剩余开奖时间 */
	private long finishTime;
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
			this.endTime = nowTime - period.getEndTime().getTime();
			this.finishTime = nowTime - period.getFinishTime().getTime();
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

	public long getEndTime() {
		return endTime;
	}

	public long getFinishTime() {
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
