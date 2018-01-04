package com.sf.lottery.service;

import com.baomidou.mybatisplus.service.IService;
import com.sf.lottery.entity.Period;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
public interface IPeriodService extends IService<Period> {
    /**
     * 通过彩票id和期号获取彩票期号对象
     *
     * @param period
     * @return
     */
    Period getPeriod(Integer lotteryId, String period);
}
