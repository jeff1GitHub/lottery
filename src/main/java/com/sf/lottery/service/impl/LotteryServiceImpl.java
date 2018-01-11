package com.sf.lottery.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sf.lottery.entity.Lottery;
import com.sf.lottery.mapper.ILotteryMapper;
import com.sf.lottery.service.ILotteryService;

/**
 *  彩票服务实现类
 */
@Service
public class LotteryServiceImpl implements ILotteryService {
	@Resource
	private ILotteryMapper lotteryMapper;
	
    @Override
    public Lottery getLotteryById(int lotteryId) {
    	Lottery lottery = lotteryMapper.selectLottery(lotteryId);
        return lottery;
    }
}
