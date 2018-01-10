package com.sf.lottery.service;

import com.sf.lottery.entity.Period;

public interface IPeriodService {
	
	/**
	 * 初始化期数
	 * @return 状态(true:成功  false:失败)
	 */
	boolean initPeriod();
	
    /**
     * 通过彩票id和期数获取彩票期数对象
     * @param lotteryId 彩票id
     * @param period 期数
     * @return 期数对象
     */
    Period getPeriod(int lotteryId, String period);
    
}
