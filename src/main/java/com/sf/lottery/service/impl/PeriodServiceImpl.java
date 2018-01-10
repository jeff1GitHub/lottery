package com.sf.lottery.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sf.lottery.entity.Period;
import com.sf.lottery.mapper.IPeriodMapper;
import com.sf.lottery.service.IPeriodService;

/**
 * 期数服务实现类
 */
@Service
public class PeriodServiceImpl implements IPeriodService {
	@Resource
	private IPeriodMapper periodMapper;
	
	@Transactional
	@Override
	public boolean initPeriod() {
		int periodNum = periodMapper.selectPeriodTemplateNum();
		if(periodNum == 120){
			Period period = periodMapper.selectLastPeriod();
		}
		return false;
	}
	
    @Override
    public Period getPeriod(int lotteryId, String period) {
        return null;
    }

}
