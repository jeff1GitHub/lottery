package com.sf.lottery.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sf.lottery.entity.Period;
import com.sf.lottery.entity.SimplePeriod;

public interface IPeriodMapper {
	
	/**
	 * 添加参数模板
	 */
	void insertPeriodTemplate();
	
	/**
	 * 查询期数模板数量
	 * @return 数模板数量
	 */
	int selectPeriodTemplateNum();
	
	/**
	 * 查询最后一期期数
	 * @return 彩票期号
	 */
	Period selectLastPeriod();
	
	/**
	 * 查询当前期数
	 * @param gameId 游戏编号
	 * @param time 当前时间
	 * @return 彩票期号
	 */
	Period selectNowPeriod(@Param("gameId") int gameId, @Param("nowTime") LocalDateTime time);
	
	/**
	 * 查询下期期数
	 * @param gameId 游戏编号
	 * @param time 当前时间
	 * @return 彩票期号
	 */
	Period selectNextPeriod(@Param("gameId") int gameId, @Param("nowTime") LocalDateTime time);
	
	/**
	 * 查询上一期期数
	 * @param gameId 游戏编号
	 * @param time 当前时间
	 * @return 彩票期号
	 */
	Period selectBeforPeriod(@Param("gameId") int gameId, @Param("nowTime") LocalDateTime time);
	
	/**
	 * 添加指定日期期数
	 */
	void insertPeriod(LocalDate date);
	
	/**
	 * 更新期数开奖结果
	 * @param id 期数编号
	 * @param result 开奖结果
	 * @return 更新条数
	 */
	int updatePeriodResult(@Param("id") int id, @Param("result") String result);
	
	/**
	 * 根据结算时间和状态查询期数
	 * @param gameId 游戏编号
	 * @param time 结算时间
	 * @param status 状态
	 * @return 期数列表(当查询失败时将返回Null)
	 */
	List<Period> selectPeriodByStatus(@Param("gameId") int gameId, @Param("nowTime") LocalDateTime time, @Param("status") int status);
	
	/**
	 * 根据日期查询期数
	 * @param gameId 游戏编号
	 * @param date 日期
	 * @return 期数列表
	 */
	List<Period> selectPeriodByDate(@Param("gameId") int gameId, @Param("date") String date);
	
	/**
	 * 根据日期查询历史期数
	 * @param gameId 游戏编号
	 * @param date 日期
	 * @return 期数列表
	 */
	List<SimplePeriod> selectHistoryPeriodByDate(@Param("gameId") int gameId, @Param("date") String date);
	
}