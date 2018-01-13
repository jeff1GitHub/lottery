package com.sf.lottery.service;

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
    
}
