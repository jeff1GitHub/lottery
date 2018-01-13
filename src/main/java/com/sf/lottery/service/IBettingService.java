package com.sf.lottery.service;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.PageInfo;

/**
 * 彩票服务接口
 */
public interface IBettingService {
	
	/**
     * 保存注单
     * @param betting 注单注单对象
     * @return 结果(true:保存成功  false:保存失败)
     */
    boolean saveBetting(Betting betting);
	
    /**
     * 通过彩票编号和彩票期号获取所有注单
     * @param lotteryId 彩票编号
     * @param period 彩票期数
     * @param pageNum 页数
     * @return 注单页(获取失败时将返回Null)
     */
    PageInfo getBettingList(int lotteryId, String period, int pageNum);

}
