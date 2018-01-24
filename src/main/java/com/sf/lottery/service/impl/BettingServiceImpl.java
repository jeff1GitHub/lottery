package com.sf.lottery.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sf.lottery.common.Constant;
import com.sf.lottery.entity.Betting;
import com.sf.lottery.entity.BettingMsg;
import com.sf.lottery.entity.BettingNum;
import com.sf.lottery.entity.BettingProject;
import com.sf.lottery.entity.BettingSquareInfo;
import com.sf.lottery.entity.BettingSquareSummary;
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
	public boolean saveBetting(List<Betting> bettings) {
		int result = bettingMapper.insertBetting(bettings);
		return result == bettings.size();
	}
	
	@Override
	public PageInfo getBettingBySquare(int lotteryId, String period, int square, int pageNum) {
		PageHelper.startPage(pageNum, Constant.BETTING_PAGE_SIZE);
		Page<Betting> page = (Page<Betting>)bettingMapper.selectBettingBySquare(lotteryId, period, square);
		return page == null ? null : new PageInfo(page);
	}

	@Override
	public List<BettingProject> getBettingProject(int lotteryId, String period) {
		List<BettingProject> list = bettingMapper.selectBettingProject(lotteryId, period);
		return list;
	}
	
    @Override
    public PageInfo getBettingList(int lotteryId, String period, int pageNum) {
    	PageHelper.startPage(pageNum, Constant.BETTING_PAGE_SIZE);
    	Page<Betting> page = (Page<Betting>)bettingMapper.selectBetting(lotteryId, period);
    	return page == null ? null : new PageInfo(page);
    }
    
    @Override
	public PageInfo getBettingPage(int lotteryId, int pageNum, String name, LocalDateTime startTime, LocalDateTime endTime) {
    	PageHelper.startPage(pageNum, Constant.BETTING_PAGE_SIZE);
    	Page<BettingMsg> page = (Page<BettingMsg>)bettingMapper.selectBettingMsgByAccount(lotteryId, name, startTime, endTime);
    	return page == null ? null : new PageInfo(page);
	}

	@Override
	public int batchSquareBetting(List<BettingSquareInfo> list) {
		int result = bettingMapper.batchUpdateSquareBetting(list);
		return result;
	}

	@Override
	public BettingSquareSummary getBettingSquare(int lotteryId, String acc, LocalDateTime startTime, LocalDateTime endTime) {
		BettingSquareSummary summary = bettingMapper.selectBettingSquare(lotteryId, acc, startTime, endTime);
		return summary;
	}

	@Override
	public BettingNum getBettingNum(int lotteryId, String acc, LocalDateTime startTime, LocalDateTime endTime) {
		BettingNum result = bettingMapper.selectBettingNum(lotteryId, acc, startTime, endTime);
		return result;
	}

}
