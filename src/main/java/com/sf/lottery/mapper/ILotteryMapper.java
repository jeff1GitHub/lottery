package com.sf.lottery.mapper;

import com.sf.lottery.entity.Lottery;

public interface ILotteryMapper {

	/**
	 * 查询彩票信息
	 * @param lotteryId 彩票id
	 * @return 彩票对象(Null时查询失败获取没有该Id对应的彩票)
	 */
	Lottery selectLottery(int lotteryId);
	
}