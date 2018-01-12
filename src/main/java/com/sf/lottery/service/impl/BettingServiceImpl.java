package com.sf.lottery.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.lottery.entity.Betting;
import com.sf.lottery.mapper.IBettingMapper;
import com.sf.lottery.service.IBettingService;

/**
 * 注单服务实现类
 */
@Service
public class BettingServiceImpl implements IBettingService {
	@Resource
	private IBettingMapper bettingMapper;

	@Override
    public boolean saveBetting(Betting betting) {
		int result = bettingMapper.insertBetting(betting);
        return result == 1;
    }
	
    @Override
    public List<Betting> getBettingList(int lotteryId, String period) {
    	List<Betting> list = bettingMapper.selectBetting(lotteryId, period);
        return list;
    }

}
