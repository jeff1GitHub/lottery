package com.sf.lottery.service.impl;

import com.sf.lottery.entity.Lottery;
import com.sf.lottery.mapper.LotteryMapper;
import com.sf.lottery.service.ILotteryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@Service
public class LotteryServiceImpl extends ServiceImpl<LotteryMapper, Lottery> implements ILotteryService {

    @Override
    public Lottery getLotteryById(Integer lotteryId) {
        return super.selectById(lotteryId);
    }
}
