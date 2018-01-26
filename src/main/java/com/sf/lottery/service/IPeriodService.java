package com.sf.lottery.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sf.lottery.entity.PageInfo;
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
     * 期数开奖
     * @param id 期数编号
     * @param result 开奖结果
     * @return 设置状态(true:设置成功  false:设置失败)
     */
    boolean setPeriodResult(int id, String result);
    
    /**
     * 获取当前展示期数
     * @param lotteryId 彩票编号
     * @return 期数(没有当前期数时返回下期期数)
     */
    Period getNowShowPeriod(int lotteryId);
    
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
	List<Period> getPeriodByStatus(int gameId, LocalDateTime time, int status);
	
	/**
	 * 根据日期查询期数
	 * @param gameId 游戏编号
	 * @param date 日期
	 * @return 期数列表
	 */
	PageInfo getPeriodByDate(int gameId, String date, int pageNum);
    
}
