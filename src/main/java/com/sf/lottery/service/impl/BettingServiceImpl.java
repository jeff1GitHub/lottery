package com.sf.lottery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.service.IBettingService;

/**
 * 注单服务实现类
 */
@Service
public class BettingServiceImpl implements IBettingService {

    @Override
    public List<Betting> getBettingList(int lotteryId, String period) {
        return null;
    }

    @Override
    public boolean saveBetting(Betting betting) {
        return false;
    }
}
