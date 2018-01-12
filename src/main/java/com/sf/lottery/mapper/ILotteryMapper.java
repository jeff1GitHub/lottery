package com.sf.lottery.mapper;

import com.sf.lottery.entity.Lottery;

public interface ILotteryMapper {

	/**
	 * 查询彩票信息
	 * @param lotteryId 彩票编号
	 * @return 彩票对象(Null时查询失败获取没有该编号对应的彩票)
	 */
	Lottery selectLottery(int lotteryId);
	
}