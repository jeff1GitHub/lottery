package com.sf.lottery.service;

import com.baomidou.mybatisplus.service.IService;
import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.Period;

import java.util.List;

/**
 * <p>
 * 注单服务接口类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
public interface IBettingService extends IService<Betting> {
    /**
     * 通过彩票id和彩票期号获取所有注单
     *
     * @param lotteryId
     * @param period
     * @return
     */
    List<Betting> getBettingList(Integer lotteryId, String period);

    /**
     * 保存注单
     *
     * @param betting
     * @return
     */
    boolean saveBetting(Betting betting);
}
