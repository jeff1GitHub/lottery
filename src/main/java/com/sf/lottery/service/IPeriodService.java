package com.sf.lottery.service;

import java.sql.Timestamp;
import java.util.List;

import com.sf.lottery.entity.Period;

/**
 * 期数服务接口
 */
public interface IPeriodService {
	
	/**
	 * 初始化期数
	 * @return 状态(true:成功  false:失败)
	 */
	boolean initPeriod();
	
    /**
     * 通过彩票编号和期数获取彩票期数对象
     * @param lotteryId 彩票编号
     * @param periodCode 期数
     * @return 期数对象
     */
    Period getPeriod(int lotteryId, String periodCode);
    
    /**
     * 期数开奖
     * @param id 期数编号
     * @param result 开奖结果
     * @return 设置状态(true:设置成功  false:设置失败)
     */
    boolean setPeriodResult(int id, String result);
    
    /**
     * 获取当前期数
     * @param lotteryId 彩票编号
     * @return 当前期数(没有时将返回Null)
     */
    Period getNowPeriod(int lotteryId);
    
    /**
	 * 查询上一期期数
	 * @param lotteryId 彩票编号
	 * @return 上期期数(没有时将返回Null)
	 */
	Period getBeforPeriod(int lotteryId);
    
    /**
	 * 根据结算时间和状态获取期数
	 * @param gameId 游戏编号
	 * @param time 结算时间
	 * @param status 状态
	 * @return 期数列表(当获取失败时将返回Null)
	 */
	List<Period> getPeriodByStatus(int gameId, Timestamp time, int status);
    
}
