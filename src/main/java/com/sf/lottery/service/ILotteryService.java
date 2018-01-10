package com.sf.lottery.service;

import com.sf.lottery.entity.Lottery;

public interface ILotteryService {
	
    Lottery getLotteryById(int lotteryId);
}
