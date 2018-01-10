package com.sf.lottery.mapper;

import java.sql.Date;
import java.sql.Timestamp;

import com.sf.lottery.entity.Period;

public interface IPeriodMapper {
	
	/**
	 * 添加参数模板
	 */
	public void insertPeriodTemplate();
	
	/**
	 * 查询期数模板数量
	 * @return 数模板数量
	 */
	public int selectPeriodTemplateNum();
	
	/**
	 * 查询最后一期期数
	 * @return 彩票期号
	 */
	public Period selectLastPeriod();
	
	/**
	 * 查询当前期数
	 * @param time 当前时间
	 * @return 彩票期号
	 */
	public Period selectNowPeriod(Timestamp time);
	
	/**
	 * 添加指定日期期数
	 */
	public void insertPeriod(Date date);
	
}