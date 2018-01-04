package com.sf.lottery.service;

import com.baomidou.mybatisplus.service.IService;
import com.sf.lottery.entity.Lottery;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
public interface ILotteryService extends IService<Lottery> {
    Lottery getLotteryById(Integer lotteryId);
}
