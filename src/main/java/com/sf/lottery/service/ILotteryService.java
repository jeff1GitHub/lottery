package com.sf.lottery.service;

import com.sf.lottery.entity.Lottery;

/**
 * 彩票服务接口
 */
public interface ILotteryService {
	
	/**
	 * 根据Id获取彩票对象
	 * @param lotteryId 彩票Id
	 * @return 彩票对象(当查询失败或者没有该Id对应的彩票时返回Null)
	 */
    Lottery getLotteryById(int lotteryId);
}
