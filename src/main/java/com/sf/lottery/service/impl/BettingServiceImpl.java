package com.sf.lottery.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sf.lottery.common.Constant;
import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.PageInfo;
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
    public PageInfo getBettingList(int lotteryId, String period, int pageNum) {
    	PageHelper.startPage(pageNum, Constant.PAGE_SIZE);
    	Page<Betting> page = (Page<Betting>)bettingMapper.selectBetting(lotteryId, period);
    	return page == null ? null : new PageInfo(page);
    }

}
