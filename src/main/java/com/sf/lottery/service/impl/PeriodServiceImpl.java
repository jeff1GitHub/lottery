package com.sf.lottery.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

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
		//彩票模板期数数量
		int periodNum = periodMapper.selectPeriodTemplateNum();
		if(periodNum == 120){
			//获取最后彩票一期信息
			Period period = periodMapper.selectLastPeriod();
			if(period != null){//判断存在期数，则判断该期数是否是属于今天，否则将生成今天的所有期数
				String code = period.getCode();
				int lastPeriodYear = Integer.parseInt(code.substring(0, 4));
				int lastPeriodMonth = Integer.parseInt(code.substring(4, 6));
				int lastPeriodDay = Integer.parseInt(code.substring(6, 8));
				
				LocalDate today = LocalDate.now();
				int nowYear = today.getYear();
				int nowMonth = today.getMonthValue();
				int nowDay = today.getDayOfMonth();
				
				if(lastPeriodYear == nowYear && lastPeriodMonth == nowMonth && lastPeriodDay == nowDay){
					return true;
				}
			}
		}else{//如果没有模板或者模板期数数量错误将重新生成模板
			periodMapper.insertPeriodTemplate();
		}
		
		//生成今天的所有期数
		periodMapper.insertPeriod(new Date(System.currentTimeMillis()));
		return true;
	}
	
    @Override
    public Period getPeriod(int lotteryId, String periodCode) {
    	if(periodCode == null || periodCode.length() == 0){
    		return null;
    	}
    	
    	//查询当前期数
    	Period period = getNowPeriod(lotteryId);
        return period != null && periodCode.equals(period.getCode()) ? period : null;
    }

	@Override
	public boolean setPeriodResult(int id, String result) {
		int num = periodMapper.updatePeriodResult(id, result);
		return num == 1;
	}

	@Override
	public Period getNowPeriod(int lotteryId) {
		//查询当前期数
    	Period period = periodMapper.selectNowPeriod(lotteryId, new Timestamp(System.currentTimeMillis()));
		return period;
	}
	
	@Override
	public Period getBeforPeriod(int lotteryId) {
		Period period = periodMapper.selectBeforPeriod(lotteryId, new Timestamp(System.currentTimeMillis()));
		return period;
	}

	@Override
	public List<Period> getPeriodByStatus(int gameId, Timestamp time, int status) {
		List<Period> list = periodMapper.selectPeriodByStatus(gameId, time, status);
		return list;
	}

}
