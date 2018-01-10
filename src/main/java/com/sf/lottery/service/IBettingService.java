package com.sf.lottery.service;

import java.util.List;

import com.sf.lottery.entity.Betting;

public interface IBettingService {
	
    /**
     * 通过彩票id和彩票期号获取所有注单
     * @param lotteryId 彩票id
     * @param period 彩票期期数
     * @return 注单
     */
    List<Betting> getBettingList(int lotteryId, String period);

    /**
     * 保存注单
     * @param betting 注单注单对象
     * @return 结果(true:保存成功  false:保存失败)
     */
    boolean saveBetting(Betting betting);
}
