package com.sf.lottery.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sf.lottery.entity.Period;
import com.sf.lottery.mapper.PeriodMapper;
import com.sf.lottery.service.IPeriodService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 期号服务实现类
 * </p>
 *
 * @author jeff
 * @since 2018-01-03
 */
@Service
public class PeriodServiceImpl extends ServiceImpl<PeriodMapper, Period> implements IPeriodService {

    @Override
    public Period getPeriod(Integer lotteryId, String period) {
        EntityWrapper<Period> wrapper = new EntityWrapper<>();
        wrapper.eq("lottery_id", lotteryId);
        wrapper.eq("period", period);
        return null;
    }
}
