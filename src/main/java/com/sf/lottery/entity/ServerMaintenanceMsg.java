package com.sf.lottery.entity;

import java.util.Date;

/**
 * 服务器维护信息
 */
public class ServerMaintenanceMsg {
	private Date endTime;
	private String msg;
	private String time;

	public Date getEndTime() {
		return endTime;
	}

	public void updateMsg(Date endTime, String msg) {
		this.endTime = endTime;
		this.msg = msg;
	}
	
	public boolean isMaintenance() {
		return endTime.getTime() >= System.currentTimeMillis();
	}
	
	public String get(){
		return time;
	}

	public String getMsg() {
		return msg;
	}
	
}
